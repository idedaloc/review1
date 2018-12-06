package com.review.review1.services.map;

import com.review.review1.model.Specialty;
import com.review.review1.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class SpecialitySeriviceMap extends AbstractMapService<Specialty, Long> implements SpecialityService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

}
