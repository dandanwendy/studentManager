package com.example.trade.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhangyue
 * @Description:  实体类
 * @Date: Create in 2020-06-29
 */
@Data
public class Tradeinfojour implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long initDate;


    private Long currDate;


    private Long currTime;


    private String allotno;


    private String opEntrustWay;


    private String entrustStatus;


    private String clientId;


    private String clientName;


    private String clientType;


    private String clientSource;


    private String clientSex;


    private String ageType;


    private String provinceNo;


    private Integer branchNo;


    private String fundCompany;


    private String productType;


    private String productName;


    private String productCode;


    private Double shares;


    private Double dealShares;


    private Double balance;


    private Double dealBalance;


    private String bsFlag;


    private Integer businessFlag;


    private String payType;


    private Double productRatio;


    private Double buyLimit;


    private Long productDays;


    private String tradeType;


    private Integer opbusinessFlag;


    private String bankNo;


    private String bankAccount;


    private String bankName;


    private String operationWay;


    private Long exchgBranchNo;


    private Long initTime;


    private String clientRisk;


}
