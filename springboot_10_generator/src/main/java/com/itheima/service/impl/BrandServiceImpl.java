package com.itheima.service.impl;

import com.itheima.domain.Brand;
import com.itheima.dao.BrandDao;
import com.itheima.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小龙
 * @since 2022-10-09
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao, Brand> implements IBrandService {

}
