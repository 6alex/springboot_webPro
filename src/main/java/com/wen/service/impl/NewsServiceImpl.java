package com.wen.service.impl;

import com.wen.dao.entity.News;
import com.wen.dao.repository.NewsMapper;
import com.wen.service.NewsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-30
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
