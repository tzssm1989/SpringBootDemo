package com.kaige.decorate;

/**
 * @author songsm
 * @data 2018/10/23 上午10:17
 * @desc 用一句话描述此类的作用
 */
public class HatDecorate extends RoleManagerWarper {

    HatDecorate(RoleManager roleManager) {
        super(roleManager);
    }

    @Override
    public String describe() {
        return super.describe()+"带上帽子";
    }
}



