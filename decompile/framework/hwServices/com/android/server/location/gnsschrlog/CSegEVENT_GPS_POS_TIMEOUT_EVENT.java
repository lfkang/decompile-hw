package com.android.server.location.gnsschrlog;

public class CSegEVENT_GPS_POS_TIMEOUT_EVENT extends ChrLogBaseEventModel {
    public LogByteArray aucCurNetStatus = new LogByteArray(4);
    public LogByteArray aucSvAzimuths = new LogByteArray(32);
    public LogByteArray auca_ucServerAdder = new LogByteArray(16);
    public LogByteArray auca_ucSvElevations = new LogByteArray(32);
    public LogByteArray auca_ucSvNo = new LogByteArray(12);
    public LogByteArray auca_ucSvSnr = new LogByteArray(32);
    public ENCEventId enEventId = new ENCEventId();
    public LogInt ia_ucPosTime = new LogInt();
    public LogInt ia_ucSvAlmMask = new LogInt();
    public LogInt ia_ucSvEphMask = new LogInt();
    public LogInt ia_ucSvUseMask = new LogInt();
    public LogLong la_ucAgpsEndTime = new LogLong();
    public LogLong la_ucAgpsStartTime = new LogLong();
    public LogLong la_ucAtlOpenTime = new LogLong();
    public LogLong la_ucConnSvrTime = new LogLong();
    public LogString strApkName = new LogString(50);
    public LogString strStartFixTime = new LogString(30);
    public LogDate tmTimeStamp = new LogDate(6);
    public LogByte ucAGPSConnReq = new LogByte();
    public LogByte ucAGPSResult = new LogByte();
    public LogByte ucAidingDataReqFlg = new LogByte();
    public LogByte ucAidingDataStatus = new LogByte();
    public LogByte ucCardIndex = new LogByte();
    public LogByte ucErrorCode = new LogByte();
    public LogByte ucGpsEngineCap = new LogByte();
    public LogByte ucGpsRunStatus = new LogByte();
    public LogByte ucLocSetStatus = new LogByte();
    public LogByte ucNetworkStatus = new LogByte();
    public LogByte ucPosMethod = new LogByte();
    public LogByte ucPosMode = new LogByte();
    public LogByte ucSUPLStatus = new LogByte();
    public LogByte ucSubErrorCode = new LogByte();
    public LogByte ucSvFlg = new LogByte();
    public LogByte ucTimeFlg = new LogByte();
    public LogByte ucucAddrFlg = new LogByte();
    public LogShort usLen = new LogShort();
    public LogShort usucServerIpPort = new LogShort();

    public CSegEVENT_GPS_POS_TIMEOUT_EVENT() {
        this.lengthMap.put("enEventId", Integer.valueOf(1));
        this.fieldMap.put("enEventId", this.enEventId);
        this.lengthMap.put("usLen", Integer.valueOf(2));
        this.fieldMap.put("usLen", this.usLen);
        this.lengthMap.put("ucErrorCode", Integer.valueOf(1));
        this.fieldMap.put("ucErrorCode", this.ucErrorCode);
        this.lengthMap.put("ucSubErrorCode", Integer.valueOf(1));
        this.fieldMap.put("ucSubErrorCode", this.ucSubErrorCode);
        this.lengthMap.put("tmTimeStamp", Integer.valueOf(6));
        this.fieldMap.put("tmTimeStamp", this.tmTimeStamp);
        this.lengthMap.put("ia_ucPosTime", Integer.valueOf(4));
        this.fieldMap.put("ia_ucPosTime", this.ia_ucPosTime);
        this.lengthMap.put("strStartFixTime", Integer.valueOf(30));
        this.fieldMap.put("strStartFixTime", this.strStartFixTime);
        this.lengthMap.put("strApkName", Integer.valueOf(50));
        this.fieldMap.put("strApkName", this.strApkName);
        this.lengthMap.put("ucPosMethod", Integer.valueOf(1));
        this.fieldMap.put("ucPosMethod", this.ucPosMethod);
        this.lengthMap.put("ucLocSetStatus", Integer.valueOf(1));
        this.fieldMap.put("ucLocSetStatus", this.ucLocSetStatus);
        this.lengthMap.put("ucCardIndex", Integer.valueOf(1));
        this.fieldMap.put("ucCardIndex", this.ucCardIndex);
        this.lengthMap.put("ucNetworkStatus", Integer.valueOf(1));
        this.fieldMap.put("ucNetworkStatus", this.ucNetworkStatus);
        this.lengthMap.put("ucGpsEngineCap", Integer.valueOf(1));
        this.fieldMap.put("ucGpsEngineCap", this.ucGpsEngineCap);
        this.lengthMap.put("ucGpsRunStatus", Integer.valueOf(1));
        this.fieldMap.put("ucGpsRunStatus", this.ucGpsRunStatus);
        this.lengthMap.put("ucAGPSConnReq", Integer.valueOf(1));
        this.fieldMap.put("ucAGPSConnReq", this.ucAGPSConnReq);
        this.lengthMap.put("ucSvFlg", Integer.valueOf(1));
        this.fieldMap.put("ucSvFlg", this.ucSvFlg);
        this.lengthMap.put("auca_ucSvNo", Integer.valueOf(12));
        this.fieldMap.put("auca_ucSvNo", this.auca_ucSvNo);
        this.lengthMap.put("auca_ucSvSnr", Integer.valueOf(32));
        this.fieldMap.put("auca_ucSvSnr", this.auca_ucSvSnr);
        this.lengthMap.put("auca_ucSvElevations", Integer.valueOf(32));
        this.fieldMap.put("auca_ucSvElevations", this.auca_ucSvElevations);
        this.lengthMap.put("aucSvAzimuths", Integer.valueOf(32));
        this.fieldMap.put("aucSvAzimuths", this.aucSvAzimuths);
        this.lengthMap.put("ia_ucSvEphMask", Integer.valueOf(4));
        this.fieldMap.put("ia_ucSvEphMask", this.ia_ucSvEphMask);
        this.lengthMap.put("ia_ucSvAlmMask", Integer.valueOf(4));
        this.fieldMap.put("ia_ucSvAlmMask", this.ia_ucSvAlmMask);
        this.lengthMap.put("ia_ucSvUseMask", Integer.valueOf(4));
        this.fieldMap.put("ia_ucSvUseMask", this.ia_ucSvUseMask);
        this.lengthMap.put("ucPosMode", Integer.valueOf(1));
        this.fieldMap.put("ucPosMode", this.ucPosMode);
        this.lengthMap.put("ucAidingDataStatus", Integer.valueOf(1));
        this.fieldMap.put("ucAidingDataStatus", this.ucAidingDataStatus);
        this.lengthMap.put("ucAidingDataReqFlg", Integer.valueOf(1));
        this.fieldMap.put("ucAidingDataReqFlg", this.ucAidingDataReqFlg);
        this.lengthMap.put("aucCurNetStatus", Integer.valueOf(4));
        this.fieldMap.put("aucCurNetStatus", this.aucCurNetStatus);
        this.lengthMap.put("ucAGPSResult", Integer.valueOf(1));
        this.fieldMap.put("ucAGPSResult", this.ucAGPSResult);
        this.lengthMap.put("ucSUPLStatus", Integer.valueOf(1));
        this.fieldMap.put("ucSUPLStatus", this.ucSUPLStatus);
        this.lengthMap.put("ucTimeFlg", Integer.valueOf(1));
        this.fieldMap.put("ucTimeFlg", this.ucTimeFlg);
        this.lengthMap.put("ucucAddrFlg", Integer.valueOf(1));
        this.fieldMap.put("ucucAddrFlg", this.ucucAddrFlg);
        this.lengthMap.put("auca_ucServerAdder", Integer.valueOf(16));
        this.fieldMap.put("auca_ucServerAdder", this.auca_ucServerAdder);
        this.lengthMap.put("la_ucAgpsStartTime", Integer.valueOf(8));
        this.fieldMap.put("la_ucAgpsStartTime", this.la_ucAgpsStartTime);
        this.lengthMap.put("la_ucAtlOpenTime", Integer.valueOf(8));
        this.fieldMap.put("la_ucAtlOpenTime", this.la_ucAtlOpenTime);
        this.lengthMap.put("la_ucConnSvrTime", Integer.valueOf(8));
        this.fieldMap.put("la_ucConnSvrTime", this.la_ucConnSvrTime);
        this.lengthMap.put("la_ucAgpsEndTime", Integer.valueOf(8));
        this.fieldMap.put("la_ucAgpsEndTime", this.la_ucAgpsEndTime);
        this.lengthMap.put("usucServerIpPort", Integer.valueOf(2));
        this.fieldMap.put("usucServerIpPort", this.usucServerIpPort);
        this.enEventId.setValue("GPS_POS_TIMEOUT_EVENT");
        this.usLen.setValue(getTotalLen());
    }
}
