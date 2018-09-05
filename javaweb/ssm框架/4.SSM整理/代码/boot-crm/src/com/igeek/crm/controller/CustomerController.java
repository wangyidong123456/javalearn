package com.igeek.crm.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igeek.crm.pojo.BaseDict;
import com.igeek.crm.pojo.Customer;
import com.igeek.crm.pojo.QueryVo;
import com.igeek.crm.service.BaseDictService;
import com.igeek.crm.service.CustomerService;
import com.igeek.crm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	// 客户来源
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	// 客户行业
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	// 客户级别
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;

	
	@RequestMapping("list")
	public String queryBaseDictList(QueryVo queryVo, Model model){
		
		try {
			// 解决get请求乱码问题
			//queryVo.getCustName() !=null && !queryVo.getCustName().equals("")
			if (StringUtils.isNotBlank(queryVo.getCustName())) {
				queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Page<Customer> page = customerService.queryCustomerByQueryVo(queryVo);
		model.addAttribute("page", page);
		

		
		//客户来源
		List<BaseDict>  fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
		//所属行业
		List<BaseDict>  industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);
		//客户级别
		List<BaseDict>  levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//数据回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		
		return "customer";
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Customer editCustomer(Long id){
		Customer customer = customerService.queryCustomerById(id);
		return customer;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer){
		this.customerService.updateCustomerById(customer);
		return "OK";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public void delete(Long id){
		customerService.deleteCustomerById(id);
	}
}
