package com.huawei.device.connectivitychrlog;

import com.huawei.connectivitylog.ConnectivityLogManager;

public class CSegEVENT_WIFI_STABILITY_SSIDSTAT extends ChrLogBaseEventModel {
    public ENCEventId enEventId = new ENCEventId();
    public LogInt iABSAssociateFailedTimes = new LogInt();
    public LogInt iABSAssociateTimes = new LogInt();
    public LogInt iAbnormalDisconnCount = new LogInt();
    public LogInt iAccessWebCnt = new LogInt();
    public LogInt iAccessWebFailedPortal = new LogInt();
    public LogInt iAccessWebReDHCPFailedPortal = new LogInt();
    public LogInt iAccessWebRoamingFailedPortal = new LogInt();
    public LogInt iAccessWebSlowlyCnt = new LogInt();
    public LogInt iAccessWebSuccCnt = new LogInt();
    public LogInt iAppDisabledAbnromalCnt = new LogInt();
    public LogInt iAppDisabledScSuccCnt = new LogInt();
    public LogInt iArpReassocOkCnt = new LogInt();
    public LogInt iArpUnreachableCnt = new LogInt();
    public LogInt iAssocByABSCnt = new LogInt();
    public LogInt iAssocCount = new LogInt();
    public LogInt iAssocDuration = new LogInt();
    public LogInt iAssocRejectAccessFullCnt = new LogInt();
    public LogInt iAssocRejectedAbnormalCnt = new LogInt();
    public LogInt iAssocRejectedScSuccCnt = new LogInt();
    public LogInt iAssocSuccCount = new LogInt();
    public LogInt iAuthCount = new LogInt();
    public LogInt iAuthDuration = new LogInt();
    public LogInt iAuthFailedAbnormalCnt = new LogInt();
    public LogInt iAuthFailedScSuccCnt = new LogInt();
    public LogInt iAuthSuccCount = new LogInt();
    public LogInt iBlackListAbnormalCnt = new LogInt();
    public LogInt iBlackListScSuccCnt = new LogInt();
    public LogInt iCHRConnectingDuration = new LogInt();
    public LogInt iConnectTotalCount = new LogInt();
    public LogInt iConnectedCount = new LogInt();
    public LogInt iConnectedDuration = new LogInt();
    public LogInt iDHCPAutoIpCount = new LogInt();
    public LogInt iDHCPStaticAccessCount = new LogInt();
    public LogInt iDhcpCount = new LogInt();
    public LogInt iDhcpDuration = new LogInt();
    public LogInt iDhcpFailedAbnormalCnt = new LogInt();
    public LogInt iDhcpFailedScSuccCnt = new LogInt();
    public LogInt iDhcpFailedStaticScSuccCnt = new LogInt();
    public LogInt iDhcpStaticCount = new LogInt();
    public LogInt iDhcpSuccCount = new LogInt();
    public LogInt iDisconnectCnt = new LogInt();
    public LogInt iDnsAbnormalCnt = new LogInt();
    public LogInt iDnsParseFailCnt = new LogInt();
    public LogInt iDnsResetScSuccCnt = new LogInt();
    public LogInt iDnsScSuccCnt = new LogInt();
    public LogInt iFirstConnInternetFailCnt = new LogInt();
    public LogInt iFirstConnInternetFailDuration = new LogInt();
    public LogInt iGatewayAbnormalCnt = new LogInt();
    public LogInt iGoodReConnectCnt = new LogInt();
    public LogInt iGoodReConnectSuccCnt = new LogInt();
    public LogInt iGwResetScSuccCnt = new LogInt();
    public LogInt iNoUserProcRunCnt = new LogInt();
    public LogInt iOnSceenConnectedDuration = new LogInt();
    public LogInt iOnSceenReConnectedCnt = new LogInt();
    public LogInt iOnScreenAbDisconnectCnt = new LogInt();
    public LogInt iOnScreenConnectCnt = new LogInt();
    public LogInt iOnScreenConnectedCnt = new LogInt();
    public LogInt iOnScreenDisconnectCnt = new LogInt();
    public LogInt iOnlyTheTxNoRxCnt = new LogInt();
    public LogInt iReDHCPAccessWebSuccCnt = new LogInt();
    public LogInt iReDHCPCnt = new LogInt();
    public LogInt iReDHCPDuration = new LogInt();
    public LogInt iReDHCPSuccCnt = new LogInt();
    public LogInt iReDhcpScSuccCnt = new LogInt();
    public LogInt iReKeyCnt = new LogInt();
    public LogInt iReKeyDuration = new LogInt();
    public LogInt iReKeySuccCnt = new LogInt();
    public LogInt iReassocScSuccCnt = new LogInt();
    public LogInt iReassocSelfCureConnectFailedCnt = new LogInt();
    public LogInt iResetScSuccCnt = new LogInt();
    public LogInt iResetSelfCureConnectFailedCnt = new LogInt();
    public LogInt iRoamingAbnormalCnt = new LogInt();
    public LogInt iRoamingAccessWebSuccCnt = new LogInt();
    public LogInt iRoamingCnt = new LogInt();
    public LogInt iRoamingDuration = new LogInt();
    public LogInt iRoamingResetScSuccCnt = new LogInt();
    public LogInt iRoamingSuccCnt = new LogInt();
    public LogInt iStaticIpScSuccCnt = new LogInt();
    public LogInt iTcpRxAbnormalCnt = new LogInt();
    public LogInt iUserEnableStaticIpCnt = new LogInt();
    public LogInt iWeakReConnectCnt = new LogInt();
    public LogInt iWeakReConnectSuccCnt = new LogInt();
    public LogLong lABSMimoScreenOnTime = new LogLong();
    public LogLong lABSMimoTime = new LogLong();
    public LogLong lABSSisoScreenOnTime = new LogLong();
    public LogLong lABSSisoTime = new LogLong();
    public LogString strAP_auth_alg = new LogString(20);
    public LogString strAP_eap = new LogString(25);
    public LogString strAP_group = new LogString(25);
    public LogString strAP_key_mgmt = new LogString(32);
    public LogString strAP_pairwise = new LogString(20);
    public LogString strAP_proto = new LogString(10);
    public LogString strBSSID = new LogString(17);
    public LogString strProxySettingInfo = new LogString(64);
    public LogString strSSID = new LogString(30);
    public LogString strapVendorInfo = new LogString(ConnectivityLogManager.WIFI_PORTAL_SAMPLES_COLLECTE);
    public LogDate tmTimeLastUpdateStamp = new LogDate(6);
    public LogDate tmTimeStamp = new LogDate(6);
    public LogDate tmTimeStartedStamp = new LogDate(6);
    public LogByte ucCardIndex = new LogByte();
    public LogByte ucMultiGWCount = new LogByte();
    public LogByte ucProxySettings = new LogByte();
    public LogShort usLen = new LogShort();

    public CSegEVENT_WIFI_STABILITY_SSIDSTAT() {
        this.lengthMap.put("enEventId", Integer.valueOf(1));
        this.fieldMap.put("enEventId", this.enEventId);
        this.lengthMap.put("usLen", Integer.valueOf(2));
        this.fieldMap.put("usLen", this.usLen);
        this.lengthMap.put("tmTimeStamp", Integer.valueOf(6));
        this.fieldMap.put("tmTimeStamp", this.tmTimeStamp);
        this.lengthMap.put("ucCardIndex", Integer.valueOf(1));
        this.fieldMap.put("ucCardIndex", this.ucCardIndex);
        this.lengthMap.put("strSSID", Integer.valueOf(30));
        this.fieldMap.put("strSSID", this.strSSID);
        this.lengthMap.put("strBSSID", Integer.valueOf(17));
        this.fieldMap.put("strBSSID", this.strBSSID);
        this.lengthMap.put("iAssocCount", Integer.valueOf(4));
        this.fieldMap.put("iAssocCount", this.iAssocCount);
        this.lengthMap.put("iAssocRejectAccessFullCnt", Integer.valueOf(4));
        this.fieldMap.put("iAssocRejectAccessFullCnt", this.iAssocRejectAccessFullCnt);
        this.lengthMap.put("iAssocByABSCnt", Integer.valueOf(4));
        this.fieldMap.put("iAssocByABSCnt", this.iAssocByABSCnt);
        this.lengthMap.put("iAssocSuccCount", Integer.valueOf(4));
        this.fieldMap.put("iAssocSuccCount", this.iAssocSuccCount);
        this.lengthMap.put("iAuthCount", Integer.valueOf(4));
        this.fieldMap.put("iAuthCount", this.iAuthCount);
        this.lengthMap.put("iAuthSuccCount", Integer.valueOf(4));
        this.fieldMap.put("iAuthSuccCount", this.iAuthSuccCount);
        this.lengthMap.put("iDhcpCount", Integer.valueOf(4));
        this.fieldMap.put("iDhcpCount", this.iDhcpCount);
        this.lengthMap.put("iDhcpSuccCount", Integer.valueOf(4));
        this.fieldMap.put("iDhcpSuccCount", this.iDhcpSuccCount);
        this.lengthMap.put("iDhcpStaticCount", Integer.valueOf(4));
        this.fieldMap.put("iDhcpStaticCount", this.iDhcpStaticCount);
        this.lengthMap.put("iDHCPStaticAccessCount", Integer.valueOf(4));
        this.fieldMap.put("iDHCPStaticAccessCount", this.iDHCPStaticAccessCount);
        this.lengthMap.put("iDHCPAutoIpCount", Integer.valueOf(4));
        this.fieldMap.put("iDHCPAutoIpCount", this.iDHCPAutoIpCount);
        this.lengthMap.put("iConnectedCount", Integer.valueOf(4));
        this.fieldMap.put("iConnectedCount", this.iConnectedCount);
        this.lengthMap.put("iConnectTotalCount", Integer.valueOf(4));
        this.fieldMap.put("iConnectTotalCount", this.iConnectTotalCount);
        this.lengthMap.put("iAbnormalDisconnCount", Integer.valueOf(4));
        this.fieldMap.put("iAbnormalDisconnCount", this.iAbnormalDisconnCount);
        this.lengthMap.put("iDisconnectCnt", Integer.valueOf(4));
        this.fieldMap.put("iDisconnectCnt", this.iDisconnectCnt);
        this.lengthMap.put("iAssocDuration", Integer.valueOf(4));
        this.fieldMap.put("iAssocDuration", this.iAssocDuration);
        this.lengthMap.put("iAuthDuration", Integer.valueOf(4));
        this.fieldMap.put("iAuthDuration", this.iAuthDuration);
        this.lengthMap.put("iDhcpDuration", Integer.valueOf(4));
        this.fieldMap.put("iDhcpDuration", this.iDhcpDuration);
        this.lengthMap.put("iConnectedDuration", Integer.valueOf(4));
        this.fieldMap.put("iConnectedDuration", this.iConnectedDuration);
        this.lengthMap.put("iFirstConnInternetFailDuration", Integer.valueOf(4));
        this.fieldMap.put("iFirstConnInternetFailDuration", this.iFirstConnInternetFailDuration);
        this.lengthMap.put("iCHRConnectingDuration", Integer.valueOf(4));
        this.fieldMap.put("iCHRConnectingDuration", this.iCHRConnectingDuration);
        this.lengthMap.put("iRoamingCnt", Integer.valueOf(4));
        this.fieldMap.put("iRoamingCnt", this.iRoamingCnt);
        this.lengthMap.put("iRoamingSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iRoamingSuccCnt", this.iRoamingSuccCnt);
        this.lengthMap.put("iRoamingDuration", Integer.valueOf(4));
        this.fieldMap.put("iRoamingDuration", this.iRoamingDuration);
        this.lengthMap.put("iReDHCPCnt", Integer.valueOf(4));
        this.fieldMap.put("iReDHCPCnt", this.iReDHCPCnt);
        this.lengthMap.put("iReDHCPSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iReDHCPSuccCnt", this.iReDHCPSuccCnt);
        this.lengthMap.put("iReDHCPDuration", Integer.valueOf(4));
        this.fieldMap.put("iReDHCPDuration", this.iReDHCPDuration);
        this.lengthMap.put("iReKeyCnt", Integer.valueOf(4));
        this.fieldMap.put("iReKeyCnt", this.iReKeyCnt);
        this.lengthMap.put("iReKeySuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iReKeySuccCnt", this.iReKeySuccCnt);
        this.lengthMap.put("iReKeyDuration", Integer.valueOf(4));
        this.fieldMap.put("iReKeyDuration", this.iReKeyDuration);
        this.lengthMap.put("iGoodReConnectCnt", Integer.valueOf(4));
        this.fieldMap.put("iGoodReConnectCnt", this.iGoodReConnectCnt);
        this.lengthMap.put("iGoodReConnectSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iGoodReConnectSuccCnt", this.iGoodReConnectSuccCnt);
        this.lengthMap.put("iWeakReConnectCnt", Integer.valueOf(4));
        this.fieldMap.put("iWeakReConnectCnt", this.iWeakReConnectCnt);
        this.lengthMap.put("iWeakReConnectSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iWeakReConnectSuccCnt", this.iWeakReConnectSuccCnt);
        this.lengthMap.put("iOnScreenConnectCnt", Integer.valueOf(4));
        this.fieldMap.put("iOnScreenConnectCnt", this.iOnScreenConnectCnt);
        this.lengthMap.put("iOnScreenConnectedCnt", Integer.valueOf(4));
        this.fieldMap.put("iOnScreenConnectedCnt", this.iOnScreenConnectedCnt);
        this.lengthMap.put("iOnScreenAbDisconnectCnt", Integer.valueOf(4));
        this.fieldMap.put("iOnScreenAbDisconnectCnt", this.iOnScreenAbDisconnectCnt);
        this.lengthMap.put("iOnScreenDisconnectCnt", Integer.valueOf(4));
        this.fieldMap.put("iOnScreenDisconnectCnt", this.iOnScreenDisconnectCnt);
        this.lengthMap.put("iOnSceenConnectedDuration", Integer.valueOf(4));
        this.fieldMap.put("iOnSceenConnectedDuration", this.iOnSceenConnectedDuration);
        this.lengthMap.put("iOnSceenReConnectedCnt", Integer.valueOf(4));
        this.fieldMap.put("iOnSceenReConnectedCnt", this.iOnSceenReConnectedCnt);
        this.lengthMap.put("iDnsAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iDnsAbnormalCnt", this.iDnsAbnormalCnt);
        this.lengthMap.put("iTcpRxAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iTcpRxAbnormalCnt", this.iTcpRxAbnormalCnt);
        this.lengthMap.put("iRoamingAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iRoamingAbnormalCnt", this.iRoamingAbnormalCnt);
        this.lengthMap.put("iGatewayAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iGatewayAbnormalCnt", this.iGatewayAbnormalCnt);
        this.lengthMap.put("iDnsScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iDnsScSuccCnt", this.iDnsScSuccCnt);
        this.lengthMap.put("iReDhcpScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iReDhcpScSuccCnt", this.iReDhcpScSuccCnt);
        this.lengthMap.put("iStaticIpScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iStaticIpScSuccCnt", this.iStaticIpScSuccCnt);
        this.lengthMap.put("iReassocScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iReassocScSuccCnt", this.iReassocScSuccCnt);
        this.lengthMap.put("iResetScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iResetScSuccCnt", this.iResetScSuccCnt);
        this.lengthMap.put("iUserEnableStaticIpCnt", Integer.valueOf(4));
        this.fieldMap.put("iUserEnableStaticIpCnt", this.iUserEnableStaticIpCnt);
        this.lengthMap.put("iAuthFailedAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iAuthFailedAbnormalCnt", this.iAuthFailedAbnormalCnt);
        this.lengthMap.put("iAssocRejectedAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iAssocRejectedAbnormalCnt", this.iAssocRejectedAbnormalCnt);
        this.lengthMap.put("iDhcpFailedAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iDhcpFailedAbnormalCnt", this.iDhcpFailedAbnormalCnt);
        this.lengthMap.put("iAppDisabledAbnromalCnt", Integer.valueOf(4));
        this.fieldMap.put("iAppDisabledAbnromalCnt", this.iAppDisabledAbnromalCnt);
        this.lengthMap.put("iAuthFailedScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iAuthFailedScSuccCnt", this.iAuthFailedScSuccCnt);
        this.lengthMap.put("iAssocRejectedScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iAssocRejectedScSuccCnt", this.iAssocRejectedScSuccCnt);
        this.lengthMap.put("iDhcpFailedScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iDhcpFailedScSuccCnt", this.iDhcpFailedScSuccCnt);
        this.lengthMap.put("iAppDisabledScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iAppDisabledScSuccCnt", this.iAppDisabledScSuccCnt);
        this.lengthMap.put("iReassocSelfCureConnectFailedCnt", Integer.valueOf(4));
        this.fieldMap.put("iReassocSelfCureConnectFailedCnt", this.iReassocSelfCureConnectFailedCnt);
        this.lengthMap.put("iResetSelfCureConnectFailedCnt", Integer.valueOf(4));
        this.fieldMap.put("iResetSelfCureConnectFailedCnt", this.iResetSelfCureConnectFailedCnt);
        this.lengthMap.put("iDnsResetScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iDnsResetScSuccCnt", this.iDnsResetScSuccCnt);
        this.lengthMap.put("iRoamingResetScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iRoamingResetScSuccCnt", this.iRoamingResetScSuccCnt);
        this.lengthMap.put("iGwResetScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iGwResetScSuccCnt", this.iGwResetScSuccCnt);
        this.lengthMap.put("iBlackListScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iBlackListScSuccCnt", this.iBlackListScSuccCnt);
        this.lengthMap.put("iBlackListAbnormalCnt", Integer.valueOf(4));
        this.fieldMap.put("iBlackListAbnormalCnt", this.iBlackListAbnormalCnt);
        this.lengthMap.put("iDhcpFailedStaticScSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iDhcpFailedStaticScSuccCnt", this.iDhcpFailedStaticScSuccCnt);
        this.lengthMap.put("strapVendorInfo", Integer.valueOf(ConnectivityLogManager.WIFI_PORTAL_SAMPLES_COLLECTE));
        this.fieldMap.put("strapVendorInfo", this.strapVendorInfo);
        this.lengthMap.put("strAP_proto", Integer.valueOf(10));
        this.fieldMap.put("strAP_proto", this.strAP_proto);
        this.lengthMap.put("strAP_key_mgmt", Integer.valueOf(32));
        this.fieldMap.put("strAP_key_mgmt", this.strAP_key_mgmt);
        this.lengthMap.put("strAP_auth_alg", Integer.valueOf(20));
        this.fieldMap.put("strAP_auth_alg", this.strAP_auth_alg);
        this.lengthMap.put("strAP_pairwise", Integer.valueOf(20));
        this.fieldMap.put("strAP_pairwise", this.strAP_pairwise);
        this.lengthMap.put("strAP_group", Integer.valueOf(25));
        this.fieldMap.put("strAP_group", this.strAP_group);
        this.lengthMap.put("strAP_eap", Integer.valueOf(25));
        this.fieldMap.put("strAP_eap", this.strAP_eap);
        this.lengthMap.put("ucProxySettings", Integer.valueOf(1));
        this.fieldMap.put("ucProxySettings", this.ucProxySettings);
        this.lengthMap.put("strProxySettingInfo", Integer.valueOf(64));
        this.fieldMap.put("strProxySettingInfo", this.strProxySettingInfo);
        this.lengthMap.put("iAccessWebCnt", Integer.valueOf(4));
        this.fieldMap.put("iAccessWebCnt", this.iAccessWebCnt);
        this.lengthMap.put("iAccessWebSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iAccessWebSuccCnt", this.iAccessWebSuccCnt);
        this.lengthMap.put("iFirstConnInternetFailCnt", Integer.valueOf(4));
        this.fieldMap.put("iFirstConnInternetFailCnt", this.iFirstConnInternetFailCnt);
        this.lengthMap.put("iOnlyTheTxNoRxCnt", Integer.valueOf(4));
        this.fieldMap.put("iOnlyTheTxNoRxCnt", this.iOnlyTheTxNoRxCnt);
        this.lengthMap.put("iDnsParseFailCnt", Integer.valueOf(4));
        this.fieldMap.put("iDnsParseFailCnt", this.iDnsParseFailCnt);
        this.lengthMap.put("iArpUnreachableCnt", Integer.valueOf(4));
        this.fieldMap.put("iArpUnreachableCnt", this.iArpUnreachableCnt);
        this.lengthMap.put("iArpReassocOkCnt", Integer.valueOf(4));
        this.fieldMap.put("iArpReassocOkCnt", this.iArpReassocOkCnt);
        this.lengthMap.put("tmTimeStartedStamp", Integer.valueOf(6));
        this.fieldMap.put("tmTimeStartedStamp", this.tmTimeStartedStamp);
        this.lengthMap.put("tmTimeLastUpdateStamp", Integer.valueOf(6));
        this.fieldMap.put("tmTimeLastUpdateStamp", this.tmTimeLastUpdateStamp);
        this.lengthMap.put("iRoamingAccessWebSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iRoamingAccessWebSuccCnt", this.iRoamingAccessWebSuccCnt);
        this.lengthMap.put("iReDHCPAccessWebSuccCnt", Integer.valueOf(4));
        this.fieldMap.put("iReDHCPAccessWebSuccCnt", this.iReDHCPAccessWebSuccCnt);
        this.lengthMap.put("iNoUserProcRunCnt", Integer.valueOf(4));
        this.fieldMap.put("iNoUserProcRunCnt", this.iNoUserProcRunCnt);
        this.lengthMap.put("iAccessWebSlowlyCnt", Integer.valueOf(4));
        this.fieldMap.put("iAccessWebSlowlyCnt", this.iAccessWebSlowlyCnt);
        this.lengthMap.put("ucMultiGWCount", Integer.valueOf(1));
        this.fieldMap.put("ucMultiGWCount", this.ucMultiGWCount);
        this.lengthMap.put("iAccessWebFailedPortal", Integer.valueOf(4));
        this.fieldMap.put("iAccessWebFailedPortal", this.iAccessWebFailedPortal);
        this.lengthMap.put("iAccessWebRoamingFailedPortal", Integer.valueOf(4));
        this.fieldMap.put("iAccessWebRoamingFailedPortal", this.iAccessWebRoamingFailedPortal);
        this.lengthMap.put("iAccessWebReDHCPFailedPortal", Integer.valueOf(4));
        this.fieldMap.put("iAccessWebReDHCPFailedPortal", this.iAccessWebReDHCPFailedPortal);
        this.lengthMap.put("iABSAssociateTimes", Integer.valueOf(4));
        this.fieldMap.put("iABSAssociateTimes", this.iABSAssociateTimes);
        this.lengthMap.put("iABSAssociateFailedTimes", Integer.valueOf(4));
        this.fieldMap.put("iABSAssociateFailedTimes", this.iABSAssociateFailedTimes);
        this.lengthMap.put("lABSMimoTime", Integer.valueOf(8));
        this.fieldMap.put("lABSMimoTime", this.lABSMimoTime);
        this.lengthMap.put("lABSSisoTime", Integer.valueOf(8));
        this.fieldMap.put("lABSSisoTime", this.lABSSisoTime);
        this.lengthMap.put("lABSMimoScreenOnTime", Integer.valueOf(8));
        this.fieldMap.put("lABSMimoScreenOnTime", this.lABSMimoScreenOnTime);
        this.lengthMap.put("lABSSisoScreenOnTime", Integer.valueOf(8));
        this.fieldMap.put("lABSSisoScreenOnTime", this.lABSSisoScreenOnTime);
        this.enEventId.setValue("WIFI_STABILITY_SSIDSTAT");
        this.usLen.setValue(getTotalLen());
    }
}