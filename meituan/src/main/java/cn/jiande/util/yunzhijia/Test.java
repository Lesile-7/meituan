package cn.jiande.util.yunzhijia;

import java.util.Date;

import cn.jiande.util.yunzhijia.pojo.AccessToken;

/** 
* @author mail: httpsession@qq.com
* @date 创建时间：2018年3月12日 下午1:16:25 
*/
public class Test {
	public static void main(String[] args) {
		//System.out.println(TokenUtil.getToken());
		//System.out.println(new Date().getTime());
		//System.out.println(TokenUtil.getTokenByTeam("500043612", "12982808", "9s1UCVINiRwzDOnggHHG"));
		//https://www.yunzhijia.com/gateway/oauth2/token/getAccessToken?eid=12982808&secret=7wVcZlKR9iU0lEUMUK29XXZltLc7EFH0&timestamp=1520837424052&scope=resGroupSecret
		//System.out.println(TokenUtil.getTokenByResGroupSecret("12982808", "7wVcZlKR9iU0lEUMUK29XXZltLc7EFH0"));
		AccessToken token=TokenUtil.getToken();
		System.out.println("token: "+token);
		//System.out.println(TokenUtil.refreshTokenByResGroupSecret("12982808",token.getRefreshToken()));
	}
}
