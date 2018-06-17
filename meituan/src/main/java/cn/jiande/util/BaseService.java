package cn.jiande.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/** 
 * 通用服务层方法，包括通用CRUD操作
 * 需spring 4.0 以上提供对泛型的注入 以及通用Mapper插件
 * 通过业务验证流程之后直接可以调用父类，即该类中方法
 * 配合通用Mapper使用
* @author : MT
* @date 创建时间：2017年11月2日 下午4:18:18 
* @version 1.0 
*/
public abstract class BaseService<T> {
	protected Mapper<T> mapper;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据ID返回实体类
	 * @param id
	 * @return
	 */
	public T queryById(Long id) {
		return this.mapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询当前数据库中所有该实体对象
	 * @return
	 */
	public List<T> queryAll() {
		return this.mapper.select(null);
	}

	/**
	 * 条件查询
	 * @param entity 根据传入实体中不为null的值作为条件查询
	 * @return
	 */
	public List<T> queryListByWhere(T entity) {
		return this.mapper.select(entity);
	}

	/**
	 * 根据传入实体中不为null的值作为条件查询 记录数
	 * @param param
	 * @return
	 */
	public Integer queryCount(T entity) {
		return this.mapper.selectCount(entity);
	}

	/**
	 * 分页查询
	 * @param param  查询条件 queryListByWhere 参数查询条件
	 * @param pageNum 页码
	 * @param pageSize 每页显示数量
	 * @return 页码信息
	 */
	public PageInfo<T> queryPageListByWhere(T param, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = this.queryListByWhere(param);
		return new PageInfo<T>(list);

	}

	/**
	 * 查询一条记录
	 * @param entity 根据实体类中的属性查询 如果为null则不会作为查询条件
	 * @return
	 */
	public T queryOne(T entity) {
		return this.mapper.selectOne(entity);
	}

	/**
	 * 保存该实体 null也会被保存
	 * @param entity 需要保存的实体对象
	 * @return
	 */
	public Integer save(T entity) {
		return this.mapper.insert(entity);
	}

	/**
	 * 保存一个实体，null的属性不会保存，会使用数据库默认值
	 * @param param
	 * @return
	 */
	public Integer saveSelect(T entity) {
		return this.mapper.insertSelective(entity);
	}

	/**
	 * 据主键更新实体全部字段，null值会被更新
	 * @param entity 需要更新的实体
	 * @return
	 */
	public Integer update(T entity) {
		return this.mapper.updateByPrimaryKey(entity);
	}

	/**
	 * 根据主键更新属性不为null的值 为null则不更新
	 * @param entity 
	 * @return
	 */
	public Integer updateSelective(T entity) {
		return this.mapper.updateByPrimaryKeySelective(entity);
	}

	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id) {
		return this.mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据ID批量删除
	 * @param clazz
	 * @param values
	 * @return
	 */
	public Integer deleteByIds(Class<T> clazz, List<Object> values) {
		Example example = new Example(clazz);
		example.createCriteria().andIn("id", values);
		return this.mapper.deleteByExample(example);
	}
}
