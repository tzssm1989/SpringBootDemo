package com.kaige.decorate;

/**
 * @author songsm
 * @data 2018/10/23 上午9:43
 * @desc 用一句话描述此类的作用
 */
public abstract class RoleManagerWarper implements RoleManager{

    private RoleManager roleManager;

    RoleManagerWarper(RoleManager roleManager){

        this.roleManager = roleManager;
    }


    public String describe(){


        return roleManager.describe();
    }
}
