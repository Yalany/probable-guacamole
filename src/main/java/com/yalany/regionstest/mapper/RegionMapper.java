package com.yalany.regionstest.mapper;

import com.yalany.regionstest.model.Region;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegionMapper {

  @Select("select * from regions")
  List<Region> findAll();

  @Select("select * from regions where id = #{id}")
  Region findById(Integer id);

  @Select("select * from regions where name = #{name}")
  Region findByName(String name);

  @Select("select * from regions where short_name = #{shortName}")
  Region findByShortName(String shortName);

  @Insert("insert into regions(name, short_name) values (#{region.name}, #{region.shortName})")
  void add(Region region);

  @Update("update regions set name = #{region.name}, short_name = #{region.shortName} where id = #{region.id}")
  void update(Region region);

  @Delete("delete from regions where id = #{id}")
  void deleteById(Integer id);

  @Delete("delete from regions where name = #{name}")
  void deleteByName(String name);

  @Delete("delete from regions where short_name = #{shortName}")
  void deleteByShortName(String shortName);
}
