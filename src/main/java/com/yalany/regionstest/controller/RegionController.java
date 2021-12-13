package com.yalany.regionstest.controller;

import com.yalany.regionstest.mapper.RegionMapper;
import com.yalany.regionstest.model.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/regions")
public class RegionController {
  private final RegionMapper regionMapper;

  @GetMapping("/all")
  @Cacheable("regions")
  public ResponseEntity<List<Region>> getAll() {
    return new ResponseEntity<>(regionMapper.findAll(), HttpStatus.OK);
  }

  @GetMapping("/by_id/{id}")
  @Cacheable("regions")
  public ResponseEntity<Region> getById(@PathVariable Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return validateReturningRegion(regionMapper.findById(id));
  }

  @GetMapping("/by_name/{name}")
  @Cacheable("regions")
  public ResponseEntity<Region> getByName(@PathVariable String name) {
    if (name == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return validateReturningRegion(regionMapper.findByName(name));
  }

  @GetMapping("/by_short_name/{shortName}")
  @Cacheable("regions")
  public ResponseEntity<Region> getByShortName(@PathVariable String shortName) {
    if (shortName == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return validateReturningRegion(regionMapper.findByShortName(shortName));
  }

  @PostMapping()
  @CacheEvict("regions")
  public ResponseEntity<Region> add(@RequestBody Region region) {
    if (region == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (regionMapper.findByName(region.getName()) != null) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    regionMapper.add(region);
    return new ResponseEntity<>(regionMapper.findByName(region.getName()), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @CacheEvict("regions")
  public ResponseEntity<Region> update(@RequestBody Region region) {
    if (region == null || region.getId() == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (regionMapper.findById(region.getId()) == null) {
      regionMapper.add(region);
      return new ResponseEntity<>(regionMapper.findByName(region.getName()), HttpStatus.CREATED);
    }
    regionMapper.update(region);
    return new ResponseEntity<>(regionMapper.findById(region.getId()), HttpStatus.OK);
  }

  @DeleteMapping("/by_id/{id}")
  @CacheEvict("regions")
  public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (regionMapper.findById(id) == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    regionMapper.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/by_name/{name}")
  @CacheEvict("regions")
  public ResponseEntity<Object> deleteByName(@PathVariable String name) {
    if (name == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (regionMapper.findByName(name) == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    regionMapper.deleteByName(name);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/by_short_name/{shortName}")
  @CacheEvict("regions")
  public ResponseEntity<Object> deleteByShortName(@PathVariable String shortName) {
    if (shortName == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (regionMapper.findByShortName(shortName) == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    regionMapper.deleteByShortName(shortName);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  private ResponseEntity<Region> validateReturningRegion(Region region) {
    if (region == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(region, HttpStatus.OK);
  }
}
