package jp.co.internous.pegasus.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.pegasus.model.domain.MstCategory;
import jp.co.internous.pegasus.model.domain.MstProduct;
import jp.co.internous.pegasus.model.form.SearchForm;
import jp.co.internous.pegasus.model.mapper.MstCategoryMapper;
import jp.co.internous.pegasus.model.mapper.MstProductMapper;
import jp.co.internous.pegasus.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/pegasus")
public class IndexController {
	
	/*
	 * フィールド定義
	 */
	
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("categories",categories);
		m.addAttribute("products",products);
		m.addAttribute("selected", 0);
		
		if(loginSession.getUserId() == 0 && loginSession.getTmpUserId() == 0) {
			Random random = new Random();
			int randomNumber = random.nextInt(900000000) + 100000000;
			loginSession.setTmpUserId(-randomNumber);
		}
		
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
	
	/**
	 * 検索処理を行う
	 * @param f 検索用フォーム
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {
		String keyword = f.getKeywords();
		
		if(keyword == null && f.getCategory() == 0) {
			List<MstProduct> products = productMapper.find();
			m.addAttribute("products",products);
		} else {
			keyword = keyword.replaceAll("　" , " ");
			keyword = keyword.replaceAll("\s{2,}", " ");
			keyword = keyword.trim();
			String[] keywords = keyword.split(" ");
			if(f.getCategory() == 0) {
				List<MstProduct> products = productMapper.findByProductName(keywords);
				m.addAttribute("products",products);
			} else {
				List<MstProduct> products = productMapper.findByCategoryAndProductName(f.getCategory(),keywords);
				m.addAttribute("products",products);
			}
		}
		
		List<MstCategory> categories = categoryMapper.find();
		m.addAttribute("keywords", keyword);
		m.addAttribute("selected", f.getCategory()); 
		m.addAttribute("categories", categories); 
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
}
