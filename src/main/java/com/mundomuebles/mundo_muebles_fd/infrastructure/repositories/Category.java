package com.mundomuebles.mundo_muebles_fd.infrastructure.repositories;

import com.mundomuebles.mundo_muebles_fd.domain.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;


   public Category(CategoryDTO categoryDTO){
       BeanUtils.copyProperties(categoryDTO, this);

   }

   public CategoryDTO toCategoryDTO()
   {
      CategoryDTO categoryDTO = new CategoryDTO();
      BeanUtils.copyProperties( this,categoryDTO);
      return categoryDTO;
   }
}
