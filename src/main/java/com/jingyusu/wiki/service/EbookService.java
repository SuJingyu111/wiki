package com.jingyusu.wiki.service;

import com.jingyusu.wiki.domain.Ebook;
import com.jingyusu.wiki.domain.EbookExample;
import com.jingyusu.wiki.mapper.EbookMapper;
import com.jingyusu.wiki.req.EbookReq;
import com.jingyusu.wiki.resp.EbookResp;
import com.jingyusu.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        return respList;
    }
}
