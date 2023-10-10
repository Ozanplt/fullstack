package com.etiya.fullstack.services.concretes;

import com.etiya.fullstack.core.utils.exceptions.types.BusinessException;
import com.etiya.fullstack.entities.Category;
import com.etiya.fullstack.entities.requests.category.AddCategoryRequest;
import com.etiya.fullstack.entities.requests.category.UpdateCategoryRequest;
import com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse;
import com.etiya.fullstack.entities.responses.category.GetCategoryResponse;
import com.etiya.fullstack.repositories.CategoryRepository;
import com.etiya.fullstack.services.abstracts.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    private MessageSource messageSource;


    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, MessageSource messageSource) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.messageSource = messageSource;
    }

    @Override
    public List<GetAllCategoryResponse> getAll() {
        return categoryRepository.getAllForListing();
    }

    @Override
    public GetCategoryResponse getById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public void add(AddCategoryRequest request) {
        Category categoryWithSameName = categoryRepository.findByName(request.getName());
        if(categoryWithSameName!=null){
            throw new BusinessException("Aynı isimde ikinci kategori eklenemez.");
        }

        Category category = modelMapper.map(request, Category.class);

        categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest request) {
        String message = messageSource.getMessage("categoryNotExist", null, LocaleContextHolder.getLocale());


        Category categoryToUpdate = categoryRepository
                .findById(request.getId())
                .orElseThrow(() -> new BusinessException(message));

        categoryToUpdate.setName(request.getName());

        categoryRepository.save(categoryToUpdate);
    }

    @Override
    public void delete(int id) {
        Category categoryToDelete = categoryRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("Böyle bir kategori bulunamadı."));

        categoryRepository.delete(categoryToDelete);
    }
}