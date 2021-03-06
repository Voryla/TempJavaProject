package com.zwk.jcaptcha;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaServiceSingleton extends ImageCaptchaEngineExtend{
	private CaptchaServiceSingleton(){}
	private static ImageCaptchaService instance = null;

	// 传入样式类
	static {
		instance = new DefaultManageableImageCaptchaService(
				new FastHashMapCaptchaStore(), new ImageCaptchaEngineExtend(),
				180, 100000, 75000);
	}

	public static ImageCaptchaService getInstance() {
		return instance;
	}
}
