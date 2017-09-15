package com.ccbjb.controller.common;

import com.ccbjb.common.utils.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by zhulin on 2017/3/18.
 */
public class BaseController {
    public static  int pageSize = 10;
    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
}
