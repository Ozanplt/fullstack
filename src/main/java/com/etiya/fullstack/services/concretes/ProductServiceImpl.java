package com.etiya.fullstack.services.concretes;

import com.etiya.fullstack.core.utils.exceptions.types.BusinessException;
import com.etiya.fullstack.entities.Product;
import com.etiya.fullstack.entities.requests.product.AddProductRequest;
import com.etiya.fullstack.entities.requests.product.UpdateProductRequest;
import com.etiya.fullstack.entities.responses.product.GetAllProductResponse;
import com.etiya.fullstack.entities.responses.product.GetProductResponse;
import com.etiya.fullstack.repositories.ProductRepository;
import com.etiya.fullstack.services.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MessageSource messageSource;
    private final ModelMapper modelMapper;
    @Override
    public List<GetAllProductResponse> getAll() {
        return productRepository.getAll();
    }

    @Override
    public GetProductResponse getById(int id) {
        String errorMessage = messageSource.getMessage("productNotExist", new Object[] { id }, LocaleContextHolder.getLocale());
        return productRepository.getById(id).orElseThrow(() -> new BusinessException(errorMessage));
    }

    @Override
    public GetProductResponse add(AddProductRequest request) {
        Product product = modelMapper.map(request, Product.class);

        product = productRepository.save(product);

        GetProductResponse response = modelMapper.map(product, GetProductResponse.class);
        return response;
    }

    @Override
    public GetProductResponse update(UpdateProductRequest request) {
        String errorMessage = messageSource.getMessage("productNotExist", new Object[] { request.getId() }, LocaleContextHolder.getLocale());
        Product productToUpdate = productRepository.findById(request.getId()).orElseThrow(() -> new BusinessException(errorMessage));

        productToUpdate = modelMapper.map(request, Product.class);

        productToUpdate = productRepository.save(productToUpdate);

        GetProductResponse response = modelMapper.map(productToUpdate, GetProductResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        String errorMessage = messageSource.getMessage("productNotExist", new Object[] { id }, LocaleContextHolder.getLocale());
        Product productToDelete = productRepository.findById(id).orElseThrow(() -> new BusinessException(errorMessage));
        productRepository.delete(productToDelete);
    }
}