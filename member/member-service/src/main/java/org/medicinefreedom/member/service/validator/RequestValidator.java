/*
 * MIT License
 *
 * Copyright (c) 2016 Medicine Freedom Organization.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.medicinefreedom.member.service.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * 通用说明：请求参数校验器.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/11 15:33
 */
public abstract class RequestValidator<T> {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(T request) {
        try {
            // 1. 通用校验（满足JSR-303规范）
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(request);
            ConstraintViolation<T> constraintViolation = getFirst(constraintViolations);
            if (constraintViolation != null) {
                throw new ValidationException(constraintViolation.getMessage());
            }

            // 2. 子类特有的业务逻辑校验
            doValidate(request);
        } catch (ValidationException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }

    }

    private ConstraintViolation<T> getFirst(Set<ConstraintViolation<T>> constraintViolations) {
        if (constraintViolations == null) {
            return null;
        }
        return constraintViolations.iterator().next();
    }

    protected abstract void doValidate(T request);
}
