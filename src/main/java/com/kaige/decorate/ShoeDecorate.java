package com.kaige.decorate;

/**
 * @author songsm
 * @data 2018/10/23 上午9:50
 * @desc 用一句话描述此类的作用
 */
public class ShoeDecorate extends RoleManagerWarper {

    public ShoeDecorate(RoleManager roleManager){
        super(roleManager);
    }


    @Override
    public String describe() {

        return super.describe()+"穿上鞋子";
    }
}
