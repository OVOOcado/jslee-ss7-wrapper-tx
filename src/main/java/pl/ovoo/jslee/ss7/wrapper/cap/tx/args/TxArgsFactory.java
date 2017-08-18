/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import javax.slee.ActivityContextInterface;

import org.mobicents.protocols.ss7.cap.api.CAPApplicationContext;
import org.mobicents.protocols.ss7.cap.api.CAPDialog;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.CAPProvider;
import org.mobicents.protocols.ss7.cap.api.EsiBcsm.TBusySpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiSms.OSmsFailureSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.EsiSms.OSmsSubmissionSpecificInfo;
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.CauseCap;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.cap.api.primitives.BCSMEvent;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CAPDialogCircuitSwitchedCall;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.AudibleIndicator;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.DpSpecificCriteria;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.EventSpecificInformationBCSM;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.FCIBCCCAMELsequence1;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.FreeFormatData;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.IPSSPCapabilities;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InbandInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeDurationChargingResult;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeInformation;
import org.mobicents.protocols.ss7.cap.api.service.sms.CAPDialogSms;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventSpecificInformationSMS;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.MOSMSCause;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.RPCause;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSAddressString;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSEvent;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.HighLayerCompatibilityInap;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;
import org.mobicents.protocols.ss7.inap.api.primitives.LegID;
import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfo;
import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfoMessageType;
import org.mobicents.protocols.ss7.isup.message.parameter.CalledPartyNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.CallingPartyNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.OriginalCalledNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectingNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectionInformation;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import org.mobicents.protocols.ss7.isup.message.parameter.UserTeleserviceInformation;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import org.mobicents.slee.resource.cap.CAPContextInterfaceFactory;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.ApplicationContextWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory;
import pl.ovoo.jslee.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BCSMEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapabilityWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallReferenceNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CancelArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeSMS;
import pl.ovoo.jslee.ss7.wrapper.cap.args.FreeFormatDataWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.FurnishChargingInformationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericDigitsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InbandInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InformationToSendWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LegType;
import pl.ovoo.jslee.ss7.wrapper.cap.args.MessageIDWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.MiscCallInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.MonitorMode;
import pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.PlayAnnouncementArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RPCauseValue;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RPCauseWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ReceivingSideIDWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseCallArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationValueWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ResetTimerArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SMSCauseWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SMSEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SendingSideIDWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SpecializedResourceReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1ConnectArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1EventReportBCSMArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1RequestReportBCSMEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2ApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2ApplyChargingReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AssistRequestInstructionsArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2BCSMEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2CallInformationReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2CallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2ConnectArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2DPSpecificCriteriaWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2EventSpecificInformationBCSMWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2FCIBCCCAMELsequence1Wrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2FurnishChargingInformationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2IPSSPCapabilitiesWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2ReleaseIfDurationExceededWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3ApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3FurnishChargingInformationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3InitialDPSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3ReleaseIfDurationExceededWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3TimeDurationChargingResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3TimeInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxCap1CallCapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxCap2CallCapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxCap3CallCapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxCapDialogWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxSmsCapDialogWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1ConnectArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1EventReportBCSMArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1RequestReportBCSMEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2ApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2ApplyChargingReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2AssistRequestInstructionsArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2BCSMEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2CallInformationReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2CallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2ConnectArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2DPSpecificCriteriaWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2EventSpecificInformationBCSMWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2FCIBCCCAMELsequence1Wrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2FurnishChargingInformationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2IPSSPCapabilitiesWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2ReleaseIfDurationExceededWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2TimeDurationChargingResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2TimeInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3ApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3FurnishChargingInformationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3InitialDPSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3ReleaseIfDurationExceededWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3TimeDurationChargingResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3TimeInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxSMSAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxSccpAddressWrapperImpl;


/**
 * TxArgsFactory.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxArgsFactory implements ArgsFactory {
    
    /** The cap provider. */
    private final CAPProvider capProvider;
    
    /** The cgin aci factory. */
    private final CAPContextInterfaceFactory cginAciFactory;
    
    /**
     * Instantiates a new tx args factory.
     *
     * @param capProvider the cap provider
     * @param cginAciFactory the cgin aci factory
     */
    public TxArgsFactory(final CAPProvider capProvider, final CAPContextInterfaceFactory cginAciFactory) {
        this.capProvider = capProvider;
        this.cginAciFactory = cginAciFactory;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createDialog(pl.ovoo.jslee.ss7.wrapper.cap.ApplicationContextWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper)
     */
    @Override
    public CapDialogWrapper createDialog(final ApplicationContextWrapper applicationContext, final SccpAddressWrapper srcSccpAddress, final SccpAddressWrapper destSccpAddress) throws Ss7WrapperException {
        try {
            final TxSccpAddressWrapperImpl srcTxSccpAddress = (TxSccpAddressWrapperImpl) srcSccpAddress;
            final TxSccpAddressWrapperImpl destTxSccpAddress = (TxSccpAddressWrapperImpl) destSccpAddress;
            final TxCapDialogWrapperImpl txCapDialogWrapper;
            final CAPDialog capDialog;
            switch (applicationContext) {
                case cap_v1_gsmSSF_to_gsmSCF_AC:
                    CAPApplicationContext capApplicationContext = CAPApplicationContext.CapV1_gsmSSF_to_gsmSCF;
                    CAPDialogCircuitSwitchedCall dialog = capProvider.getCAPServiceCircuitSwitchedCall().createNewDialog(capApplicationContext, srcTxSccpAddress.getTxSccpAddress(), destTxSccpAddress.getTxSccpAddress());
                    txCapDialogWrapper = new TxCap1CallCapDialogWrapper(dialog, capProvider);
                    capDialog = dialog;
                    break;
                case cap_v2_gsmSSF_to_gsmSCF_AC:
                    capApplicationContext = CAPApplicationContext.CapV2_gsmSSF_to_gsmSCF;
                    dialog = capProvider.getCAPServiceCircuitSwitchedCall().createNewDialog(capApplicationContext, srcTxSccpAddress.getTxSccpAddress(), destTxSccpAddress.getTxSccpAddress());
                    txCapDialogWrapper = new TxCap2CallCapDialogWrapper(dialog, capProvider);
                    capDialog = dialog;
                    break;
                case cap_v2_gsmSRF_to_gsmSCF_AC:
                    capApplicationContext = CAPApplicationContext.CapV2_gsmSRF_to_gsmSCF;
                    dialog = capProvider.getCAPServiceCircuitSwitchedCall().createNewDialog(capApplicationContext, srcTxSccpAddress.getTxSccpAddress(), destTxSccpAddress.getTxSccpAddress());
                    txCapDialogWrapper = new TxCap2CallCapDialogWrapper(dialog, capProvider);
                    capDialog = dialog;
                    break;
                case cap_v3_capssf_scfGenericAC:
                    capApplicationContext = CAPApplicationContext.CapV3_gsmSSF_scfGeneric;
                    dialog = capProvider.getCAPServiceCircuitSwitchedCall().createNewDialog(capApplicationContext, srcTxSccpAddress.getTxSccpAddress(), destTxSccpAddress.getTxSccpAddress());
                    txCapDialogWrapper = new TxCap3CallCapDialogWrapper(dialog, capProvider);
                    capDialog = dialog;
                    break;
                case cap_v3_cap3_sms_AC:
                    capApplicationContext = CAPApplicationContext.CapV3_cap3_sms;
                    CAPDialogSms dialogSms = capProvider.getCAPServiceSms().createNewDialog(capApplicationContext, srcTxSccpAddress.getTxSccpAddress(), destTxSccpAddress.getTxSccpAddress());
                    txCapDialogWrapper = new TxSmsCapDialogWrapperImpl(dialogSms);
                    capDialog = dialogSms;
                    break;
                default:
                    throw new Ss7WrapperException("Unknown Application Context: " + applicationContext);

            }
            txCapDialogWrapper.setActivityContextInterface(cginAciFactory.getActivityContextInterface(capDialog));
            return txCapDialogWrapper;

        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createDialog(javax.slee.ActivityContextInterface)
     */
    @Override
    public CapDialogWrapper createDialog(final ActivityContextInterface aci) {
    	if (aci == null) {
            return null;
        }
        final CAPDialog dialog = (CAPDialog) aci.getActivity();

        final TxCapDialogWrapperImpl txCapDialogWrapper;
        if (dialog instanceof CAPDialogCircuitSwitchedCall) {
            final CAPApplicationContext capApplicationContext = dialog.getApplicationContext();
            switch (capApplicationContext) {
                case CapV1_gsmSSF_to_gsmSCF:
                    txCapDialogWrapper = new TxCap1CallCapDialogWrapper((CAPDialogCircuitSwitchedCall) dialog, capProvider);
                    break;
                case CapV2_gsmSRF_to_gsmSCF:
                case CapV2_assistGsmSSF_to_gsmSCF:
                case CapV2_gsmSSF_to_gsmSCF:
                    txCapDialogWrapper = new TxCap2CallCapDialogWrapper((CAPDialogCircuitSwitchedCall) dialog, capProvider);
                    break;
                default:
                    txCapDialogWrapper = new TxCap3CallCapDialogWrapper((CAPDialogCircuitSwitchedCall) dialog, capProvider);
            }
        } else if (dialog instanceof CAPDialogSms) {
        	txCapDialogWrapper = new TxSmsCapDialogWrapperImpl((CAPDialogSms)dialog);
        } else {
        	txCapDialogWrapper = new TxCapDialogWrapperImpl(dialog);
        }
        txCapDialogWrapper.setActivityContextInterface(aci);
        return txCapDialogWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createRpCause(pl.ovoo.jslee.ss7.wrapper.cap.args.RPCauseValue)
     */
    @Override
    public RPCauseWrapper createRpCause(final RPCauseValue rpCauseValue) {
        final RPCause rpCause = capProvider.getCAPParameterFactory().createRPCause(rpCauseValue.getValue());
        return new TxRPCauseWrapperImpl(rpCause);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createRequestReportSmsEventArg(pl.ovoo.jslee.ss7.wrapper.cap.args.SMSEventWrapper[])
     */
    @Override
    public RequestReportSMSEventArgWrapper createRequestReportSmsEventArg(final SMSEventWrapper[] smsEventWrappers) {
    	return new TxRequestReportSMSEventArgWrapper(smsEventWrappers);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createSmsEvent(pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeSMS, pl.ovoo.jslee.ss7.wrapper.cap.args.MonitorMode)
     */
    @Override
    public SMSEventWrapper createSmsEvent(final EventTypeSMS eventTypeSMS, final MonitorMode monitorMode) {
        final SMSEvent smsEvent = capProvider.getCAPParameterFactory().createSMSEvent(org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS.getInstance(eventTypeSMS.getValue()),
                org.mobicents.protocols.ss7.cap.api.primitives.MonitorMode.getInstance(monitorMode.getValue()));
        return new TxSMSEventWrapper(smsEvent);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createConnectSMSArg()
     */
    @Override
    public ConnectSMSArgWrapper createConnectSMSArg() throws Ss7WrapperException {
        return new TxConnectSMSArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCause()
     */
    @Override
    public CauseWrapper createCause() {
        return new TxCauseWrapper(capProvider.getISUPParameterFactory().createCauseIndicators());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCause(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper.CauseValue)
     */
    @Override
    public CauseWrapper createCause(final CauseWrapper.CauseValue causeValue) {
        final CauseIndicators causeIndicators = capProvider.getISUPParameterFactory().createCauseIndicators();
        causeIndicators.setCauseValue(causeValue.getValue());
        return new TxCauseWrapper(causeIndicators);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createReleaseCallArg()
     */
    @Override
    public ReleaseCallArgWrapper createReleaseCallArg() {
        return new TxReleaseCallArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createReleaseSmsArg(pl.ovoo.jslee.ss7.wrapper.cap.args.RPCauseWrapper)
     */
    @Override
    public ReleaseSMSArgWrapper createReleaseSmsArg(RPCauseWrapper rPCauseWrapper){
    	return new TxReleaseSMSArgWrapper(((TxRPCauseWrapperImpl)rPCauseWrapper).getTxRpCause());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap1RequestReportBcsmEventArg()
     */
    @Override
    public Cap1RequestReportBCSMEventArgWrapper createCap1RequestReportBcsmEventArg() {
        return new TxCap1RequestReportBCSMEventArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createBcsmEvent(pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM, pl.ovoo.jslee.ss7.wrapper.cap.args.MonitorMode, pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper)
     */
    @Override
    public BCSMEventWrapper createBcsmEvent(final EventTypeBCSM eventTypeBCSM, final MonitorMode monitorMode, final LegIDWrapper legID) {
        final BCSMEvent bcsmEvent = getTxBcsmEvent(eventTypeBCSM, monitorMode, legID, null);
        return new TxBCSMEventWrapper(bcsmEvent);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2BcsmEvent(pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM, pl.ovoo.jslee.ss7.wrapper.cap.args.MonitorMode, pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper, pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2DPSpecificCriteriaWrapper)
     */
    @Override
    public Cap2BCSMEventWrapper createCap2BcsmEvent(final EventTypeBCSM eventTypeBCSM, final MonitorMode monitorMode, final LegIDWrapper legID,
                                                    final Cap2DPSpecificCriteriaWrapper dpSpecificCriteria) {
        final BCSMEvent bcsmEvent = getTxBcsmEvent(eventTypeBCSM, monitorMode, legID, dpSpecificCriteria);
        return new TxCap2BCSMEventWrapper(bcsmEvent);
    }

    /**
     * Gets the tx bcsm event.
     *
     * @param eventTypeBCSM the event type bcsm
     * @param monitorMode the monitor mode
     * @param legID the leg id
     * @param dpSpecificCriteria the dp specific criteria
     * @return the tx bcsm event
     */
    private BCSMEvent getTxBcsmEvent(final EventTypeBCSM eventTypeBCSM, final MonitorMode monitorMode, final LegIDWrapper legID, final Cap2DPSpecificCriteriaWrapper dpSpecificCriteria) {
        final org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM eventTypeBCSMTx =
                eventTypeBCSM != null ? org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM.getInstance(eventTypeBCSM.getValue()) : null;
        final org.mobicents.protocols.ss7.cap.api.primitives.MonitorMode monitorModeTx =
                monitorMode != null ? org.mobicents.protocols.ss7.cap.api.primitives.MonitorMode.getInstance(monitorMode.getValue()) : null;
        final LegID legIDTx = legID != null ? ((TxLegIDWrapper) legID).getTxLegID() : null;
        final DpSpecificCriteria dpSpecificCriteriaTx = dpSpecificCriteria != null ? ((TxCap2DPSpecificCriteriaWrapper) dpSpecificCriteria).getTxDpSpecificCriteria() : null;

        return capProvider.getCAPParameterFactory().createBCSMEvent(eventTypeBCSMTx, monitorModeTx, legIDTx, dpSpecificCriteriaTx, false);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createLegId(boolean, pl.ovoo.jslee.ss7.wrapper.cap.args.LegType)
     */
    @Override
    public LegIDWrapper createLegId(final boolean isSendingSideID, final LegType legType) {
        final org.mobicents.protocols.ss7.inap.api.primitives.LegType legTypeTx =
                legType != null ?  org.mobicents.protocols.ss7.inap.api.primitives.LegType.getInstance(legType.getValue()) : null;
        LegID legID = capProvider.getINAPParameterFactory().createLegID(isSendingSideID, legTypeTx);
        return new TxLegIDWrapper(legID);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2DpSpecificCriteria(int)
     */
    @Override
    public Cap2DPSpecificCriteriaWrapper createCap2DpSpecificCriteria(final int applicationTimer) {
        final DpSpecificCriteria dpSpecificCriteria = capProvider.getCAPParameterFactory().createDpSpecificCriteria(applicationTimer);
        return new TxCap2DPSpecificCriteriaWrapper(dpSpecificCriteria);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2ConnectArg()
     */
    @Override
    public Cap2ConnectArgWrapper createCap2ConnectArg() {
        return new TxCap2ConnectArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap1ConnectArg()
     */
    @Override
    public Cap1ConnectArgWrapper createCap1ConnectArg() {
        return new TxCap1ConnectArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createRedirectionInformation(pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper.Redirecting, pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper.OriginalReason, pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper.RedirectingReason, int)
     */
    @Override
    public RedirectionInformationWrapper createRedirectionInformation(final RedirectionInformationWrapper.Redirecting redirecting,
                                                                      final RedirectionInformationWrapper.OriginalReason originalReason,
                                                                      final RedirectionInformationWrapper.RedirectingReason redirectingReason,
                                                                      final int redirectionCounter) throws Ss7WrapperException {
        final RedirectionInformation redirectionInformation = capProvider.getISUPParameterFactory().createRedirectionInformation();
        redirectionInformation.setOriginalRedirectionReason(originalReason.getValue());
        redirectionInformation.setRedirectionReason(redirectingReason.getValue());
        redirectionInformation.setRedirectingIndicator(redirecting.getValue());
        redirectionInformation.setRedirectionCounter(redirectionCounter);
        try {
            final RedirectionInformationInap redirectionInformationInap = capProvider.getINAPParameterFactory().createRedirectionInformationInap(redirectionInformation);
            return new TxRedirectionInformationWrapper(redirectionInformationInap);
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCalledPartyNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper.Nature, pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper.RoutingToInternalNetworkNumber, pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper.NumberingPlan, java.lang.String)
     */
    @Override
    public CalledPartyNumberWrapper createCalledPartyNumber(final CalledPartyNumberWrapper.Nature nature,
                                                            final CalledPartyNumberWrapper.RoutingToInternalNetworkNumber routingToInternalNetworkNumber,
                                                            final CalledPartyNumberWrapper.NumberingPlan numberingPlan,
                                                            final String address) throws Ss7WrapperException {
        final CalledPartyNumber calledPartyNumber = capProvider.getISUPParameterFactory().createCalledPartyNumber();
        calledPartyNumber.setNatureOfAddresIndicator(nature.getValue());
        calledPartyNumber.setInternalNetworkNumberIndicator(routingToInternalNetworkNumber.getValue());
        calledPartyNumber.setNumberingPlanIndicator(numberingPlan.getValue());
        calledPartyNumber.setAddress(address);
        try {
            final CalledPartyNumberCap calledPartyNumberCap = capProvider.getCAPParameterFactory().createCalledPartyNumberCap(calledPartyNumber);
            return new TxCalledPartyNumberWrapper(calledPartyNumberCap);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCalledPartyNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper)
     */
    @Override
    public CalledPartyNumberWrapper createCalledPartyNumber(final CalledPartyNumberWrapper calledPartyNumber) throws Ss7WrapperException {
        final TxCalledPartyNumberWrapper txCalledPartyNumberWrapper = (TxCalledPartyNumberWrapper) calledPartyNumber;
        final byte[] data = txCalledPartyNumberWrapper.getTxCalledPartyNumber().getData().clone();
        final CalledPartyNumberCap calledPartyNumberCap = capProvider.getCAPParameterFactory().createCalledPartyNumberCap(data);
        return new TxCalledPartyNumberWrapper(calledPartyNumberCap);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCallingPartyNumberWrapper(pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartyNumberWrapper.Nature, boolean, pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartyNumberWrapper.NumberingPlan, pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartyNumberWrapper.Presentation, pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartyNumberWrapper.Screening, java.lang.String)
     */
    @Override
    public CallingPartyNumberWrapper createCallingPartyNumberWrapper(final CallingPartyNumberWrapper.Nature nature,
                                                                     final boolean numberIncomplete,
                                                                     final CallingPartyNumberWrapper.NumberingPlan numberingPlan,
                                                                     final CallingPartyNumberWrapper.Presentation presentation,
                                                                     final CallingPartyNumberWrapper.Screening screening,
                                                                     final String address) throws Ss7WrapperException {
        final CallingPartyNumber callingPartyNumber = capProvider.getISUPParameterFactory().createCallingPartyNumber();
        callingPartyNumber.setNumberIncompleteIndicator(numberIncomplete ? CallingPartyNumber._NI_INCOMPLETE : CallingPartyNumber._NI_COMPLETE);
        if (nature != null) {
            callingPartyNumber.setNatureOfAddresIndicator(nature.getValue());
        }
        if (numberingPlan != null) {
            callingPartyNumber.setNumberingPlanIndicator(numberingPlan.getValue());
        }
        if (presentation != null) {
            callingPartyNumber.setAddressRepresentationREstrictedIndicator(presentation.getValue());
        }
        if (screening != null) {
            callingPartyNumber.setScreeningIndicator(screening.getValue());
        }
        callingPartyNumber.setAddress(address);

        try {
            return new TxCallingPartyNumberWrapper(capProvider.getCAPParameterFactory().createCallingPartyNumberCap(callingPartyNumber));
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createOriginalCalledNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper.Nature, pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper.NumberingPlan, pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper.Presentation, java.lang.String)
     */
    @Override
    public OriginalCalledNumberWrapper createOriginalCalledNumber(final OriginalCalledNumberWrapper.Nature nature,
                                                                  final OriginalCalledNumberWrapper.NumberingPlan numberingPlan,
                                                                  final OriginalCalledNumberWrapper.Presentation presentation,
                                                                  final String address) throws Ss7WrapperException {
        final OriginalCalledNumber originalCalledNumber = capProvider.getISUPParameterFactory().createOriginalCalledNumber();
        originalCalledNumber.setNatureOfAddresIndicator(nature.getValue());
        originalCalledNumber.setNumberingPlanIndicator(numberingPlan.getValue());
        originalCalledNumber.setAddressRepresentationRestrictedIndicator(presentation.getValue());
        originalCalledNumber.setAddress(address);
        try {
            final OriginalCalledNumberCap originalCalledNumberCap = capProvider.getCAPParameterFactory().createOriginalCalledNumberCap(originalCalledNumber);
            return new TxOriginalCalledNumberWrapper(originalCalledNumberCap);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createRedirectingPartyNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper.Nature, pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper.NumberingPlan, pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper.Presentation, java.lang.String)
     */
    @Override
    public RedirectingPartyNumberWrapper createRedirectingPartyNumber(final RedirectingPartyNumberWrapper.Nature nature, final RedirectingPartyNumberWrapper.NumberingPlan numberingPlan, final RedirectingPartyNumberWrapper.Presentation presentation, final String address) throws Ss7WrapperException {
        final RedirectingNumber redirectingNumber = capProvider.getISUPParameterFactory().createRedirectingNumber();
        redirectingNumber.setNatureOfAddresIndicator(nature.getValue());
        redirectingNumber.setNumberingPlanIndicator(numberingPlan.getValue());
        redirectingNumber.setAddressRepresentationRestrictedIndicator(presentation.getValue());
        redirectingNumber.setAddress(address);
        try {
            final RedirectingPartyIDCap redirectingPartyIDCap = capProvider.getCAPParameterFactory().createRedirectingPartyIDCap(redirectingNumber);
            return new TxRedirectingPartyNumberWrapper(redirectingPartyIDCap);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCancelArgWrapper()
     */
    @Override
    public CancelArgWrapper createCancelArgWrapper() {
        return new TxCancelArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createApplyChargingArg()
     */
    @Override
    public ApplyChargingArgWrapper createApplyChargingArg() {
        return new TxApplyChargingArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2ApplyChargingArg()
     */
    @Override
    public Cap2ApplyChargingArgWrapper createCap2ApplyChargingArg() {
        return new TxCap2ApplyChargingArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3ApplyChargingArg()
     */
    @Override
    public Cap3ApplyChargingArgWrapper createCap3ApplyChargingArg() {
        return new TxCap3ApplyChargingArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2ReleaseIfDurationExceeded(boolean)
     */
    @Override
    public Cap2ReleaseIfDurationExceededWrapper createCap2ReleaseIfDurationExceeded(final boolean tone) {
        final AudibleIndicator audibleIndicator = capProvider.getCAPParameterFactory().createAudibleIndicator(tone);
        return new TxCap2ReleaseIfDurationExceededWrapper(audibleIndicator);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2TimeDurationChargingWrapper(long, java.lang.Long, pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2ReleaseIfDurationExceededWrapper)
     */
    @Override
    public Cap2AChBillingChargingCharacteristicsWrapper.Cap2TimeDurationChargingWrapper createCap2TimeDurationChargingWrapper(final long maxCallPeriodDuration,
                                                                                                                              final Long tariffSwitchInterval,
                                                                                                                              final Cap2ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper) {
        return new TxCap2AChBillingChargingCharacteristicsWrapper.TxCap2TimeDurationChargingWrapper(maxCallPeriodDuration, tariffSwitchInterval, cap2ReleaseIfDurationExceededWrapper);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3ReleaseIfDurationExceeded(boolean)
     */
    @Override
    public Cap3ReleaseIfDurationExceededWrapper createCap3ReleaseIfDurationExceeded(final boolean tone) {
        final AudibleIndicator audibleIndicator = capProvider.getCAPParameterFactory().createAudibleIndicator(tone);
        return new TxCap3ReleaseIfDurationExceededWrapper(audibleIndicator);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3TimeDurationChargingWrapper(long, java.lang.Long, pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3ReleaseIfDurationExceededWrapper)
     */
    @Override
    public Cap3AChBillingChargingCharacteristicsWrapper.Cap3TimeDurationChargingWrapper createCap3TimeDurationChargingWrapper(final long maxCallPeriodDuration, final Long tariffSwitchInterval, final Cap3ReleaseIfDurationExceededWrapper cap3ReleaseIfDurationExceededWrapper) {
        return new TxCap3AChBillingChargingCharacteristicsWrapper.TxCap3TimeDurationChargingWrapper(maxCallPeriodDuration, tariffSwitchInterval, cap3ReleaseIfDurationExceededWrapper);

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3AChBillingChargingCharacteristics(pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3AChBillingChargingCharacteristicsWrapper.Cap3TimeDurationChargingWrapper)
     */
    @Override
    public Cap3AChBillingChargingCharacteristicsWrapper createCap3AChBillingChargingCharacteristics(final Cap3AChBillingChargingCharacteristicsWrapper.Cap3TimeDurationChargingWrapper cap3TimeDurationChargingWrapper) {
        final TxCap3ReleaseIfDurationExceededWrapper txCap3ReleaseIfDurationExceededWrapper;
        if (cap3TimeDurationChargingWrapper.getReleaseIfDurationExceeded() != null) {
            txCap3ReleaseIfDurationExceededWrapper = (TxCap3ReleaseIfDurationExceededWrapper)cap3TimeDurationChargingWrapper.getReleaseIfDurationExceeded();
        } else {
            txCap3ReleaseIfDurationExceededWrapper = null;
        }
        final CAMELAChBillingChargingCharacteristics camelaChBillingChargingCharacteristics = capProvider.getCAPParameterFactory().createCAMELAChBillingChargingCharacteristics(cap3TimeDurationChargingWrapper.getMaxCallPeriodDuration(),
                cap3TimeDurationChargingWrapper.getReleaseIfDurationExceeded() != null,
                cap3TimeDurationChargingWrapper.getTariffSwitchInterval(),
                txCap3ReleaseIfDurationExceededWrapper != null ? txCap3ReleaseIfDurationExceededWrapper.getTxAudibleIndicator() : null,
                null, true);
        return new TxCap3AChBillingChargingCharacteristicsWrapper(camelaChBillingChargingCharacteristics);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createSendingSideId(pl.ovoo.jslee.ss7.wrapper.cap.args.LegType)
     */
    @Override
    public SendingSideIDWrapper createSendingSideId(final LegType legType) {
        final SendingSideID sendingSideID = capProvider.getCAPParameterFactory().
                createSendingSideID(org.mobicents.protocols.ss7.inap.api.primitives.LegType.getInstance(legType.getValue()));
        return new TxSendingSideIDWrapper(sendingSideID);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2CallInformationRequestArg()
     */
    @Override
    public Cap2CallInformationRequestArgWrapper createCap2CallInformationRequestArg() {
        return new TxCap2CallInformationRequestArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createEstablishTemporaryConnectionArg()
     */
    @Override
    public EstablishTemporaryConnectionArgWrapper createEstablishTemporaryConnectionArg() {
        return new TxEstablishTemporaryConnectionArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createGenericNumber()
     */
    @Override
    public GenericNumberWrapper createGenericNumber() {
        final GenericNumber genericNumber = capProvider.getISUPParameterFactory().createGenericNumber();
        return new TxGenericNumberWrapper(genericNumber);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createGenericDigits()
     */
    @Override
    public GenericDigitsWrapper createGenericDigits() {
        final GenericDigits genericDigits = capProvider.getISUPParameterFactory().createGenericDigits();
        return new TxGenericDigitsWrapper(genericDigits);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createPlayAnnouncementArg()
     */
    @Override
    public PlayAnnouncementArgWrapper createPlayAnnouncementArg() {
        return new TxPlayAnnouncementArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createInformationToSend(pl.ovoo.jslee.ss7.wrapper.cap.args.InbandInfoWrapper)
     */
    @Override
    public InformationToSendWrapper createInformationToSend(final InbandInfoWrapper inbandInfo) {
        final InformationToSend informationToSend = capProvider.getCAPParameterFactory().createInformationToSend(((TxInbandInfoWrapper) inbandInfo).getTxInbandInfo());
        return new TxInformationToSendWrapper(informationToSend);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createInbandInfo(pl.ovoo.jslee.ss7.wrapper.cap.args.MessageIDWrapper)
     */
    @Override
    public InbandInfoWrapper createInbandInfo(final MessageIDWrapper messageID) {
        final TxMessageIDWrapper txMessageIDWrapper = (TxMessageIDWrapper) messageID;
        final InbandInfo inbandInfo = capProvider.getCAPParameterFactory().createInbandInfo(txMessageIDWrapper.getTxMessageID(), null, null, null);
        return new TxInbandInfoWrapper(inbandInfo);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createMessageID(int)
     */
    @Override
    public MessageIDWrapper createMessageID(final int elementaryMessageID) {
        final MessageID messageID = capProvider.getCAPParameterFactory().createMessageID(elementaryMessageID);
        return new TxMessageIDWrapper(messageID);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createBearerCapability(pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper)
     */
    @Override
    public BearerCapabilityWrapper createBearerCapability(final BearerCapWrapper bearerCapWrapper) {
        final TxBearerCapWrapper txBearerCapWrapper = (TxBearerCapWrapper) bearerCapWrapper;
        final BearerCapability bearerCapability = capProvider.getCAPParameterFactory().createBearerCapability(txBearerCapWrapper.getTxBearerCap());
        return new TxBearerCapabilityWrapper(bearerCapability);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createBearerCap(pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper)
     */
    @Override
    public BearerCapWrapper createBearerCap(final ITU_TUserServiceInformationWrapper userServiceInformationWrapper) throws Ss7WrapperException {
        final TxITU_TUserServiceInformationWrapper txITU_tUserServiceInformationWrapper1 = (TxITU_TUserServiceInformationWrapper) userServiceInformationWrapper;
        try {
            final BearerCap bearerCap = capProvider.getCAPParameterFactory().createBearerCap(txITU_tUserServiceInformationWrapper1.getTxUserServiceInformation());
            return new TxBearerCapWrapper(bearerCap);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createLayer1Capability(pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper.Layer1CapabilityWrapper.Layer1Protocol)
     */
    @Override
    public ITU_TUserServiceInformationWrapper.Layer1CapabilityWrapper createLayer1Capability(final ITU_TUserServiceInformationWrapper.Layer1CapabilityWrapper.Layer1Protocol layer1Protocol) {
        return new TxITU_TUserServiceInformationWrapper.TxLayer1CapabilityWrapper(layer1Protocol);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createItuTUserServiceInformation(pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper.TransferCapability, pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper.TransferRate, pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper.TransferMode, pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper.Layer1CapabilityWrapper)
     */
    @Override
    public ITU_TUserServiceInformationWrapper createItuTUserServiceInformation(final ITU_TUserServiceInformationWrapper.TransferCapability transferCapability,
                                                                               final ITU_TUserServiceInformationWrapper.TransferRate transferRate,
                                                                               final ITU_TUserServiceInformationWrapper.TransferMode transferMode,
                                                                               final ITU_TUserServiceInformationWrapper.Layer1CapabilityWrapper layer1Capability) {
        final UserServiceInformation userServiceInformation = capProvider.getISUPParameterFactory().createUserServiceInformation();
        if (transferCapability != null) {
            userServiceInformation.setInformationTransferCapability(transferCapability.getValue());
        }
        if (transferRate != null) {
            userServiceInformation.setInformationTransferRate(transferRate.getValue());
        }
        if (transferMode != null) {
            userServiceInformation.setTransferMode(transferMode.getValue());
        }
        if (layer1Capability != null) {
            if (layer1Capability.getLayer1Protocol() != null) {
                userServiceInformation.setL1UserInformation(layer1Capability.getLayer1Protocol().getValue());
            }
        }
        return new TxITU_TUserServiceInformationWrapper(userServiceInformation);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createTimeAndTimezone(int, int, int, int, int, int, int)
     */
    @Override
    public TimeAndTimezoneWrapper createTimeAndTimezone(final int year, final int month, final int day, final int hour, final int minute, final int second, final int timeZone) {
        final TimeAndTimezone timeAndTimezone = capProvider.getCAPParameterFactory().createTimeAndTimezone(year, month, day, hour, minute, second, timeZone);
        return new TxTimeAndTimezoneWrapper(timeAndTimezone);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createHighLayerCompatibility(pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper.Characteristics, pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper.CodingStandard, pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper.Interpretation, pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper.Presentation)
     */
    @Override
    public HighLayerCompatibilityWrapper createHighLayerCompatibility(final HighLayerCompatibilityWrapper.Characteristics characteristics,
                                                                      final HighLayerCompatibilityWrapper.CodingStandard codingStandard,
                                                                      final HighLayerCompatibilityWrapper.Interpretation interpretation,
                                                                      final HighLayerCompatibilityWrapper.Presentation presentation) throws Ss7WrapperException {
        final UserTeleserviceInformation userTeleserviceInformation = capProvider.getISUPParameterFactory().createUserTeleserviceInformation();
        if (characteristics != null) {
            userTeleserviceInformation.setHighLayerCharIdentification(characteristics.getValue());
        }
        if (codingStandard != null) {
            userTeleserviceInformation.setCodingStandard(codingStandard.getValue());
        }
        if (interpretation != null) {
            userTeleserviceInformation.setInterpretation(interpretation.getValue());
        }
        if (presentation != null) {
            userTeleserviceInformation.setPresentationMethod(presentation.getValue());
        }
        try {
            final HighLayerCompatibilityInap highLayerCompatibilityInap = capProvider.getINAPParameterFactory().createHighLayerCompatibilityInap(userTeleserviceInformation);
            return new TxHighLayerCompatibilityWrapper(highLayerCompatibilityInap);
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap1InitialDpArg()
     */
    @Override
    public Cap1InitialDPArgWrapper createCap1InitialDpArg() {
        return new TxCap1InitialDPArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2InitialDpArg()
     */
    @Override
    public Cap2InitialDPArgWrapper createCap2InitialDpArg() {
        return new TxCap2InitialDPArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3InitialDpArg()
     */
    @Override
    public Cap3InitialDPArgWrapper createCap3InitialDpArg() {
        return new TxCap3InitialDPArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3InitialDpSMSArg()
     */
    @Override
    public Cap3InitialDPSMSArgWrapper createCap3InitialDpSMSArg() {
        return new TxCap3InitialDPSMSArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCallReferenceNumber(byte[])
     */
    @Override
    public CallReferenceNumberWrapper createCallReferenceNumber(final byte[] callReferenceNumber) {
        final CallReferenceNumber callReferenceNumber1 = capProvider.getMAPParameterFactory().createCallReferenceNumber(callReferenceNumber);
        return new TxCallReferenceNumberWrapper(callReferenceNumber1);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCalledPartyBcdNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper.NumberType, pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper.NumberingPlan, java.lang.String)
     */
    @Override
    public CalledPartyBCDNumberWrapper createCalledPartyBcdNumber(final CalledPartyBCDNumberWrapper.NumberType numberType,
                                                                  final CalledPartyBCDNumberWrapper.NumberingPlan numberingPlan,
                                                                  final String address) throws Ss7WrapperException {
            final AddressNature addressNature;
            if (numberType == null) {
                addressNature = null;
            } else {
                addressNature = AddressNature.getInstance(numberType.getValue());
            }

            final NumberingPlan numberingPlanTx;
            if (numberingPlan == null) {
                numberingPlanTx = null;
            } else {
                numberingPlanTx = NumberingPlan.getInstance(numberingPlan.getValue());
            }
        try {
            final CalledPartyBCDNumber calledPartyBCDNumber = capProvider.getCAPParameterFactory().createCalledPartyBCDNumber(addressNature, numberingPlanTx, address);
            return new TxCalledPartyBCDNumberWrapper(calledPartyBCDNumber);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap1EventReportBcsmArg()
     */
    @Override
    public Cap1EventReportBCSMArgWrapper createCap1EventReportBcsmArg() {
        return new TxCap1EventReportBCSMArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createEventReportSMSArg(pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeSMS, pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper)
     */
    @Override
    public EventReportSMSArgWrapper createEventReportSMSArg(EventTypeSMS smsEvent, EventSpecificInformationSMSWrapper eventSpecificInformationSMS) {
    	TxEventReportSMSArgWrapperImpl erSMS =  new TxEventReportSMSArgWrapperImpl();
    	if(eventSpecificInformationSMS != null){
    		erSMS.setTxEventSpecificInformationBCSM(((TxEventSpecificInformationSMSWrapper)eventSpecificInformationSMS).getEventSpecificInformationSMS());
    	}
    	erSMS.setTxEventTypeSMS(org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS.getInstance(smsEvent.getValue()));
    	return erSMS;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createReceivingSideID(pl.ovoo.jslee.ss7.wrapper.cap.args.LegType)
     */
    @Override
    public ReceivingSideIDWrapper createReceivingSideID(final LegType legType) {
        final org.mobicents.protocols.ss7.inap.api.primitives.LegType legTypeTx = org.mobicents.protocols.ss7.inap.api.primitives.LegType.getInstance(legType.getValue());
        final ReceivingSideID receivingSideID = capProvider.getCAPParameterFactory().createReceivingSideID(legTypeTx);
        return new TxReceivingSideIDWrapper(receivingSideID);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createMiscCallInfo(pl.ovoo.jslee.ss7.wrapper.cap.args.MiscCallInfoWrapper.MessageType)
     */
    @Override
    public MiscCallInfoWrapper createMiscCallInfo(final MiscCallInfoWrapper.MessageType messageType) {
        final MiscCallInfoMessageType miscCallInfoMessageType = MiscCallInfoMessageType.getInstance(messageType.getValue());
        final MiscCallInfo miscCallInfo = capProvider.getINAPParameterFactory().createMiscCallInfo(miscCallInfoMessageType, null);
        return new TxMiscCallInfoWrapper(miscCallInfo);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createEventSpecificInformationBCSM(pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper.TCalledPartyBusySpecificInfoWrapper)
     */
    @Override
    public EventSpecificInformationBCSMWrapper createEventSpecificInformationBCSM(
            final EventSpecificInformationBCSMWrapper.TCalledPartyBusySpecificInfoWrapper tCalledPartyBusySpecificInfoWrapper) {
        final TxEventSpecificInformationBCSMWrapper.TxTCalledPartyBusySpecificInfoWrapper txTCalledPartyBusySpecificInfoWrapper =
                (TxEventSpecificInformationBCSMWrapper.TxTCalledPartyBusySpecificInfoWrapper) tCalledPartyBusySpecificInfoWrapper;
        final EventSpecificInformationBCSM eventSpecificInformationBCSM =
                capProvider.getCAPParameterFactory().createEventSpecificInformationBCSM(txTCalledPartyBusySpecificInfoWrapper.getTxTCalledPartyBusySpecificInfo());
        return new TxEventSpecificInformationBCSMWrapper(eventSpecificInformationBCSM);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createEventSpecificInformationSMSSubmittedWrapper()
     */
    @Override
    public EventSpecificInformationSMSWrapper createEventSpecificInformationSMSSubmittedWrapper() throws Ss7WrapperException {
		OSmsSubmissionSpecificInfo oSmsSubmissionSpecificInfo = capProvider.getCAPParameterFactory().createOSmsSubmissionSpecificInfo();
		EventSpecificInformationSMS eventSpecificInformationSMS = capProvider.getCAPParameterFactory().createEventSpecificInformationSMSImpl(oSmsSubmissionSpecificInfo);
		return new TxEventSpecificInformationSMSWrapper(eventSpecificInformationSMS);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createEventSpecificInformationSMSFailureWrapper(pl.ovoo.jslee.ss7.wrapper.cap.args.SMSCauseWrapper.FailureCause)
     */
    @Override
    public EventSpecificInformationSMSWrapper createEventSpecificInformationSMSFailureWrapper(SMSCauseWrapper.FailureCause failureCause) throws Ss7WrapperException {
    	MOSMSCause cause = MOSMSCause.getInstance(failureCause.getValue());
		OSmsFailureSpecificInfo  oSmsFailureSpecificInfo = capProvider.getCAPParameterFactory().createOSmsFailureSpecificInfo(
				cause);
		EventSpecificInformationSMS eventSpecificInformationSMS = capProvider.getCAPParameterFactory().createEventSpecificInformationSMSImpl(oSmsFailureSpecificInfo);
		return new TxEventSpecificInformationSMSWrapper(eventSpecificInformationSMS);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createTCalledPartyBusySpecificInfoWrapper(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper)
     */
    @Override
    public EventSpecificInformationBCSMWrapper.TCalledPartyBusySpecificInfoWrapper createTCalledPartyBusySpecificInfoWrapper(final CauseWrapper causeWrapper) throws Ss7WrapperException {
        final TxCauseWrapper txCauseWrapper = (TxCauseWrapper) causeWrapper;
        try {
            final CauseCap causeCap = capProvider.getCAPParameterFactory().createCauseCap(txCauseWrapper.getTxCause());
            final TBusySpecificInfo tBusySpecificInfo = capProvider.getCAPParameterFactory().createTBusySpecificInfo(causeCap, false, false, null);
            return new TxEventSpecificInformationBCSMWrapper.TxTCalledPartyBusySpecificInfoWrapper(tBusySpecificInfo);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2TCalledPartyBusySpecificInfoWrapper(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper, boolean)
     */
    @Override
    public Cap2EventSpecificInformationBCSMWrapper.Cap2TCalledPartyBusySpecificInfoWrapper createCap2TCalledPartyBusySpecificInfoWrapper(final CauseWrapper causeWrapper,
                                                                                                                                  final boolean callForwarded) throws Ss7WrapperException {
        final TxCauseWrapper txCauseWrapper = (TxCauseWrapper) causeWrapper;
        try {
            final CauseCap causeCap = capProvider.getCAPParameterFactory().createCauseCap(txCauseWrapper.getTxCause());
            final TBusySpecificInfo tBusySpecificInfo = capProvider.getCAPParameterFactory().createTBusySpecificInfo(causeCap, callForwarded, false, null);
            return new TxCap2EventSpecificInformationBCSMWrapper.TxCap2TCalledPartyBusySpecificInfoWrapper(tBusySpecificInfo);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createAssistRequestInstructionsArg()
     */
    @Override
    public AssistRequestInstructionsArgWrapper createAssistRequestInstructionsArg() {
        return new TxAssistRequestInstructionsArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2AssistRequestInstructionsArg()
     */
    @Override
    public Cap2AssistRequestInstructionsArgWrapper createCap2AssistRequestInstructionsArg() {
        return new TxCap2AssistRequestInstructionsArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2IPSSPCapabilities(boolean, boolean, boolean, boolean, boolean)
     */
    @Override
    public Cap2IPSSPCapabilitiesWrapper createCap2IPSSPCapabilities(final boolean ipRoutingAddressSupported,
                                                                    final boolean voiceBackSupported,
                                                                    final boolean voiceInformationSupportedViaSpeechRecognition,
                                                                    final boolean voiceInformationSupportedViaVoiceRecognition,
                                                                    final boolean generationOfVoiceAnnouncementsFromTextSupported) {
        final IPSSPCapabilities ipsspCapabilities = capProvider.getCAPParameterFactory().createIPSSPCapabilities(ipRoutingAddressSupported,
        voiceBackSupported,
        voiceInformationSupportedViaSpeechRecognition,
        voiceInformationSupportedViaVoiceRecognition,
        generationOfVoiceAnnouncementsFromTextSupported, null);
        return new TxCap2IPSSPCapabilitiesWrapper(ipsspCapabilities);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createSpecializedResourceReportArg()
     */
    @Override
    public SpecializedResourceReportArgWrapper createSpecializedResourceReportArg() {
        return new TxSpecializedResourceReportArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2ApplyChargingReportArg()
     */
    @Override
    public Cap2ApplyChargingReportArgWrapper createCap2ApplyChargingReportArg() {
        return new TxCap2ApplyChargingReportArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2TimeDurationChargingResult(pl.ovoo.jslee.ss7.wrapper.cap.args.ReceivingSideIDWrapper, pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeInformationWrapper, boolean)
     */
    @Override
    public Cap2TimeDurationChargingResultWrapper createCap2TimeDurationChargingResult(final ReceivingSideIDWrapper partyToCharge,
                                                                                      final Cap2TimeInformationWrapper timeInformation,
                                                                                      final boolean callActive) {
        final ReceivingSideID partyToChargeTx;
        if (partyToCharge == null) {
            partyToChargeTx = null;
        } else {
            partyToChargeTx = ((TxReceivingSideIDWrapper) partyToCharge).getTxReceivingSideID();
        }
        final TimeInformation timeInformationTx;
        if (timeInformation == null) {
            timeInformationTx = null;
        } else {
            timeInformationTx = ((TxCap2TimeInformationWrapper) timeInformation).getTxTimeInformation();
        }
        final TimeDurationChargingResult timeDurationChargingResult =
                capProvider.getCAPParameterFactory().createTimeDurationChargingResult(partyToChargeTx, timeInformationTx, false, callActive, null, null);
        return new TxCap2TimeDurationChargingResultWrapper(timeDurationChargingResult);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3TimeDurationChargingResult(pl.ovoo.jslee.ss7.wrapper.cap.args.ReceivingSideIDWrapper, pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3TimeInformationWrapper, boolean)
     */
    @Override
    public Cap3TimeDurationChargingResultWrapper createCap3TimeDurationChargingResult(final ReceivingSideIDWrapper partyToCharge, final Cap3TimeInformationWrapper timeInformation, final boolean callActive) {
        final ReceivingSideID partyToChargeTx;
        if (partyToCharge == null) {
            partyToChargeTx = null;
        } else {
            partyToChargeTx = ((TxReceivingSideIDWrapper) partyToCharge).getTxReceivingSideID();
        }
        final TimeInformation timeInformationTx;
        if (timeInformation == null) {
            timeInformationTx = null;
        } else {
            timeInformationTx = ((TxCap2TimeInformationWrapper) timeInformation).getTxTimeInformation();
        }
        final TimeDurationChargingResult timeDurationChargingResult =
                capProvider.getCAPParameterFactory().createTimeDurationChargingResult(partyToChargeTx, timeInformationTx, false, callActive, null, null);
        return new TxCap3TimeDurationChargingResultWrapper(timeDurationChargingResult);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2TimeInformation(int)
     */
    @Override
    public Cap2TimeInformationWrapper createCap2TimeInformation(final int timeIfNoTariffSwitch) {
        final TimeInformation timeInformation = capProvider.getCAPParameterFactory().createTimeInformation(timeIfNoTariffSwitch);
        return new TxCap2TimeInformationWrapper(timeInformation);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3TimeInformation(int)
     */
    @Override
    public Cap3TimeInformationWrapper createCap3TimeInformation(final int timeIfNoTariffSwitch) {
        final TimeInformation timeInformation = capProvider.getCAPParameterFactory().createTimeInformation(timeIfNoTariffSwitch);
        return new TxCap3TimeInformationWrapper(timeInformation);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2CallInformationReportArg()
     */
    @Override
    public Cap2CallInformationReportArgWrapper createCap2CallInformationReportArg() {
        return new TxCap2CallInformationReportArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createRequestedInformation(pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationValueWrapper)
     */
    @Override
    public RequestedInformationWrapper createRequestedInformation(final RequestedInformationValueWrapper requestedInformationValueWrapper) {
        final TxRequestedInformationValueWrapper txRequestedInformationValueWrapper = (TxRequestedInformationValueWrapper) requestedInformationValueWrapper;
        return new TxRequestedInformationWrapper(txRequestedInformationValueWrapper.getTxRequestedInformationValue());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createRequestedInformationValueReleaseCause(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper)
     */
    @Override
    public RequestedInformationValueWrapper createRequestedInformationValueReleaseCause(final CauseWrapper cause) throws Ss7WrapperException {
        final TxCauseWrapper txCauseWrapper = (TxCauseWrapper) cause;
        try {
            final CauseCap causeCap = capProvider.getCAPParameterFactory().createCauseCap(txCauseWrapper.getTxCause());
            final RequestedInformation requestedInformation = capProvider.getCAPParameterFactory().createRequestedInformation_ReleaseCause(causeCap);
            return new TxRequestedInformationValueWrapper(requestedInformation);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createRequestedInformationValueCallConnectedElapsedTime(int)
     */
    @Override
    public RequestedInformationValueWrapper createRequestedInformationValueCallConnectedElapsedTime(final int callConnectedElapsedTime) throws Ss7WrapperException {
        final RequestedInformation requestedInformation = capProvider.getCAPParameterFactory().createRequestedInformation_CallConnectedElapsedTime(callConnectedElapsedTime);
        return new TxRequestedInformationValueWrapper(requestedInformation);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createResetTimerArg()
     */
    @Override
    public ResetTimerArgWrapper createResetTimerArg() {
        return new TxResetTimerArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2AChBillingChargingCharacteristics(pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper.Cap2TimeDurationChargingWrapper)
     */
    @Override
    public Cap2AChBillingChargingCharacteristicsWrapper createCap2AChBillingChargingCharacteristics(
            final Cap2AChBillingChargingCharacteristicsWrapper.Cap2TimeDurationChargingWrapper cap2TimeDurationChargingWrapper) {
        final TxCap2ReleaseIfDurationExceededWrapper txCap2ReleaseIfDurationExceededWrapper;
        if (cap2TimeDurationChargingWrapper.getReleaseIfDurationExceeded() != null) {
            txCap2ReleaseIfDurationExceededWrapper = (TxCap2ReleaseIfDurationExceededWrapper)cap2TimeDurationChargingWrapper.getReleaseIfDurationExceeded();
        } else {
            txCap2ReleaseIfDurationExceededWrapper = null;
        }
        final CAMELAChBillingChargingCharacteristics camelaChBillingChargingCharacteristics = capProvider.getCAPParameterFactory().createCAMELAChBillingChargingCharacteristics(cap2TimeDurationChargingWrapper.getMaxCallPeriodDuration(),
                cap2TimeDurationChargingWrapper.getReleaseIfDurationExceeded() != null,
                cap2TimeDurationChargingWrapper.getTariffSwitchInterval(),
                txCap2ReleaseIfDurationExceededWrapper != null ? txCap2ReleaseIfDurationExceededWrapper.getTxAudibleIndicator() : null,
                null, false);
        return new TxCap2AChBillingChargingCharacteristicsWrapper(camelaChBillingChargingCharacteristics);
    }

    /**
     * Gets the cap provider.
     *
     * @return the cap provider
     */
    public CAPProvider getCapProvider() {
        return capProvider;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createSMSAddressString(pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.Nature, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.NumberingPlan, java.lang.String)
     */
    @Override
    public AddressStringWrapper createSMSAddressString(AddressStringWrapper.Nature nature,
    		AddressStringWrapper.NumberingPlan numberingPlan,
            String address){
    	final AddressNature addressNature;
        if (nature == null) {
            addressNature = null;
        } else {
            addressNature = AddressNature.getInstance(nature.getValue());
        }

        final NumberingPlan numberingPlanTx;
        if (numberingPlan == null) {
            numberingPlanTx = null;
        } else {
            numberingPlanTx = NumberingPlan.getInstance(numberingPlan.getValue());
        }
    	final SMSAddressString sMSAddressString = capProvider.getCAPParameterFactory().createSMSAddressString(
    			addressNature,
    			numberingPlanTx,
    			address);
        return new TxSMSAddressStringWrapperImpl(sMSAddressString);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createFurnishChargingInformationArg()
     */
    @Override
    public FurnishChargingInformationArgWrapper createFurnishChargingInformationArg() {
        return new TxFurnishChargingInformationArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2FurnishChargingInformationArg()
     */
    @Override
    public Cap2FurnishChargingInformationArgWrapper createCap2FurnishChargingInformationArg() {
        return new TxCap2FurnishChargingInformationArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap3FurnishChargingInformationArg()
     */
    @Override
    public Cap3FurnishChargingInformationArgWrapper createCap3FurnishChargingInformationArg() {
        return new TxCap3FurnishChargingInformationArgWrapper();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createCap2FCIBCCCAMELsequence1(pl.ovoo.jslee.ss7.wrapper.cap.args.FreeFormatDataWrapper, pl.ovoo.jslee.ss7.wrapper.cap.args.SendingSideIDWrapper)
     */
    @Override
    public Cap2FCIBCCCAMELsequence1Wrapper createCap2FCIBCCCAMELsequence1(final FreeFormatDataWrapper freeFormatData, final SendingSideIDWrapper partyToCharge) {
        final FreeFormatData txFreeFormatData;
        if (freeFormatData == null) {
            txFreeFormatData = null;
        } else {
            txFreeFormatData = ((TxFreeFormatDataWrapper) freeFormatData).getTxFreeFormatData();
        }
        final SendingSideID txPartyToCharge;
        if (partyToCharge == null) {
            txPartyToCharge = null;
        } else {
            txPartyToCharge = ((TxSendingSideIDWrapper) partyToCharge).getTxSendingSideID();
        }
        final FCIBCCCAMELsequence1 fcibcccameLsequence1 =  capProvider.getCAPParameterFactory().createFCIBCCCAMELsequence1(txFreeFormatData, txPartyToCharge, null);
        return new TxCap2FCIBCCCAMELsequence1Wrapper(fcibcccameLsequence1);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ArgsFactory#createFreeFormatData(byte[])
     */
    @Override
    public FreeFormatDataWrapper createFreeFormatData(final byte[] freeFormatData) {
        final FreeFormatData txFreeFormatData = capProvider.getCAPParameterFactory().createFreeFormatData(freeFormatData);
        return new TxFreeFormatDataWrapper(txFreeFormatData);
    }


	/**
	 * Gets the cgin aci factory.
	 *
	 * @return the cgin aci factory
	 */
	public CAPContextInterfaceFactory getCginAciFactory() {
		return cginAciFactory;
	}
    
    
}
