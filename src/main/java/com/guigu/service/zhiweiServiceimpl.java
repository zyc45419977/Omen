package com.guigu.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guigu.dao.ZhiweiDao;
import com.guigu.vo.PageVO;
import com.guigu.vo.zhiweiVo;
@Service("zhiweiService")
public class zhiweiServiceimpl implements zhiweiService{
	@Autowired
	ZhiweiDao zhiweidao;
	@Override
	public int addzhiwei(zhiweiVo zhiweivo) {
	
		return zhiweidao.addzhiwei(zhiweivo);
	}

	@Override
	public int updatezhiwei(zhiweiVo zhiweivo) {
	
		return zhiweidao.updatezhiwei(zhiweivo);
	}

	@Override
	public int deletezhiweiById(Integer id) {

		return zhiweidao.deletezhiweiById(id);
	}

	@Override
	public zhiweiVo queryById(Integer id) {
		
		return zhiweidao.queryById(id);
	}

	@Override
	public PageVO queryzhiweiByPage(int currpage, int pagesize) {
		PageVO<zhiweiVo> pageVO = new PageVO<zhiweiVo>();
		currpage = (currpage-1)*pagesize;
		pageVO.setRows(zhiweidao.queryzhiweiByPage(currpage, pagesize));
		pageVO.setTotal(zhiweidao.queryCount1());
		return pageVO;
	}

}
