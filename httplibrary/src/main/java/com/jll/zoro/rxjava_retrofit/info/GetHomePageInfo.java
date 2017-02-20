package com.jll.zoro.rxjava_retrofit.info;

import java.util.List;

/**
 * @Author : Zoro.
 * @Date : 2017/2/16.
 * @Describe :
 */
public class GetHomePageInfo {
    private String accountMoney;
    private String contractNums;
    private String messagetNums;
    private String planNums;
    private List<TpgPackage> tpgPackages;
    private List<String> urls;
    private String tioCustomType;

    public String getTioCustomType() {
        return tioCustomType;
    }

    public void setTioCustomType(String tioCustomType) {
        this.tioCustomType = tioCustomType;
    }

    public String getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(String accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getContractNums() {
        return contractNums;
    }

    public void setContractNums(String contractNums) {
        this.contractNums = contractNums;
    }

    public String getMessagetNums() {
        return messagetNums;
    }

    public void setMessagetNums(String messagetNums) {
        this.messagetNums = messagetNums;
    }

    public String getPlanNums() {
        return planNums;
    }

    public void setPlanNums(String planNums) {
        this.planNums = planNums;
    }

    public List<TpgPackage> getTpgPackages() {
        return tpgPackages;
    }

    public void setTpgPackages(List<TpgPackage> tpgPackages) {
        this.tpgPackages = tpgPackages;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}

