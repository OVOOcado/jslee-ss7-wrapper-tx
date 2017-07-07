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

package pl.ovoo.ss7.wrapper.cap.tx;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.CAPProvider;
import org.mobicents.protocols.ss7.cap.api.isup.CauseCap;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CAPDialogCircuitSwitchedCall;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.DestinationRoutingAddress;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.FCIBCCCAMELsequence1;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.IPSSPCapabilities;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.CallCapDialogWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CancelArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventReportBCSMArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.FurnishChargingInformationArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.InitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.PlayAnnouncementArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ReleaseCallArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RequestReportBCSMEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.SpecializedResourceReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxAssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCancelArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxEstablishTemporaryConnectionArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxEventReportBCSMArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxFurnishChargingInformationArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxInitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxPlayAnnouncementArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxReleaseCallArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxRequestReportBCSMEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap1.TxCap1InitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap2.TxCap2AssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap2.TxCap2CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap2.TxCap2CallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap2.TxCap2FurnishChargingInformationArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap2.TxCap2InitialDPArgWrapper;

/**
 * TxSmsCapDialogWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallCapDialogWrapperImpl extends TxCapDialogWrapperImpl implements CallCapDialogWrapper {

    public static final int INVOKE_TIMEOUT = 600000;
    protected final CAPDialogCircuitSwitchedCall dialogCircuitSwitchedCall;
    protected final CAPProvider capProvider;

    public TxCallCapDialogWrapperImpl(final CAPDialogCircuitSwitchedCall dialogCircuitSwitchedCall, final CAPProvider capProvider) {
        super(dialogCircuitSwitchedCall);
        this.dialogCircuitSwitchedCall = dialogCircuitSwitchedCall;
        this.capProvider = capProvider;
    }


    @Override
    public int sendReleaseCall(final ReleaseCallArgWrapper releaseCallArg) throws Ss7WrapperException {
        final TxReleaseCallArgWrapper txReleaseCallArgWrapper = (TxReleaseCallArgWrapper) releaseCallArg;
        try {
            final CauseCap causeCap = capProvider.getCAPParameterFactory().createCauseCap(txReleaseCallArgWrapper.getTxCauseIndicators());
            return dialogCircuitSwitchedCall.addReleaseCallRequest(causeCap).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendContinue() throws Ss7WrapperException {
        try {
            return dialogCircuitSwitchedCall.addContinueRequest().intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendConnect(final ConnectArgWrapper connectArg) throws Ss7WrapperException {
        try {
            final TxConnectArgWrapper txConnectArgWrapper = (TxConnectArgWrapper) connectArg;
            final DestinationRoutingAddress destinationRoutingAddress;
            if (txConnectArgWrapper.getTxDestinationRoutingAddress() == null) {
                destinationRoutingAddress = null;
            } else {
                destinationRoutingAddress = capProvider.getCAPParameterFactory().createDestinationRoutingAddress(txConnectArgWrapper.getTxDestinationRoutingAddress());
            }
            return dialogCircuitSwitchedCall.addConnectRequest(destinationRoutingAddress, null,
                    txConnectArgWrapper.getTxOriginalCalledPartyID(), null, null, null,
                    txConnectArgWrapper.getTxRedirectingPartyIDCap(), txConnectArgWrapper.getTxRedirectionInformationInap(), null,
                    null, null, null,
                    null, false, false, false,
                    null, false).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendDisconnectForwardConnection() throws Ss7WrapperException {
        try {
            return dialogCircuitSwitchedCall.addDisconnectForwardConnectionRequest().intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendRequestReportBCSMEvent(final RequestReportBCSMEventArgWrapper requestReportBCSMEventArg) throws Ss7WrapperException {
        final TxRequestReportBCSMEventArgWrapper txRequestReportBCSMEventArgWrapper = (TxRequestReportBCSMEventArgWrapper) requestReportBCSMEventArg;
        try {
            return dialogCircuitSwitchedCall.addRequestReportBCSMEventRequest(txRequestReportBCSMEventArgWrapper.getTxBcsmEvents(), null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendCancel(final CancelArgWrapper cancelArg) throws Ss7WrapperException {
        try {
            final TxCancelArgWrapper txCancelArgWrapper = (TxCancelArgWrapper) cancelArg;
            if (txCancelArgWrapper.isTxAllRequests()) {
                return dialogCircuitSwitchedCall.addCancelRequest_AllRequests().intValue();
            } else {
                throw new Ss7WrapperException("Only Cancel all requests implemented");
            }
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendCallInformationRequest(final CallInformationRequestArgWrapper callInformationRequestArg) throws Ss7WrapperException {
        final TxCallInformationRequestArgWrapper txCallInformationRequestArgWrapper = (TxCallInformationRequestArgWrapper) callInformationRequestArg;
        final SendingSideID txLegID;
        if (txCallInformationRequestArgWrapper instanceof TxCap2CallInformationRequestArgWrapper) {
            txLegID = ((TxCap2CallInformationRequestArgWrapper) txCallInformationRequestArgWrapper).getTxLegID();
        } else {
            txLegID = null;
        }
        try {
            return dialogCircuitSwitchedCall.addCallInformationRequestRequest(txCallInformationRequestArgWrapper.getTxRequestedInformationTypes(),
                    null, txLegID).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }

    @Override
    public int sendApplyCharging(final ApplyChargingArgWrapper applyChargingArg) throws Ss7WrapperException {
        final TxApplyChargingArgWrapper txApplyChargingArgWrapper = (TxApplyChargingArgWrapper) applyChargingArg;
        try {
            return dialogCircuitSwitchedCall.addApplyChargingRequest(txApplyChargingArgWrapper.getTxAchBillingChargingCharacteristics(),
                    txApplyChargingArgWrapper.getTxPartyToCharge(), null, null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendEstablishTemporaryConnection(final EstablishTemporaryConnectionArgWrapper establishTemporaryConnectionArgWrapper) throws Ss7WrapperException {
        final TxEstablishTemporaryConnectionArgWrapper txEstablishTemporaryConnectionArgWrapper = (TxEstablishTemporaryConnectionArgWrapper) establishTemporaryConnectionArgWrapper;
        try {
            final org.mobicents.protocols.ss7.cap.api.isup.Digits assistingSSPIPRoutingAddress;
            final org.mobicents.protocols.ss7.cap.api.isup.Digits correlationID;
            if (txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress() == null) {
                assistingSSPIPRoutingAddress = null;
            } else {
                assistingSSPIPRoutingAddress = capProvider.getCAPParameterFactory().createDigits_GenericNumber(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress());
            }
            if (txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID() == null) {
                correlationID = null;
            } else {
                correlationID = capProvider.getCAPParameterFactory().createDigits_GenericDigits(txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID());
            }
            return dialogCircuitSwitchedCall.addEstablishTemporaryConnectionRequest(assistingSSPIPRoutingAddress,
                    correlationID, null, null, null, null, null, null,
                    null, null, null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendPlayAnnouncement(final long timeout, final PlayAnnouncementArgWrapper playAnnouncementArg) throws Ss7WrapperException {
        final TxPlayAnnouncementArgWrapper txPlayAnnouncementArgWrapper = (TxPlayAnnouncementArgWrapper) playAnnouncementArg;
        try {
            return dialogCircuitSwitchedCall.addPlayAnnouncementRequest((int) timeout, txPlayAnnouncementArgWrapper.getTxInformationToSend(),
                    null, txPlayAnnouncementArgWrapper.getTxRequestAnnouncementComplete(), null, null, null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendInitialDP(final InitialDPArgWrapper initialDPArg) throws Ss7WrapperException {
        try {
            final TxInitialDPArgWrapper txInitialDPArgWrapper = (TxInitialDPArgWrapper) initialDPArg;
            TimeAndTimezone timeAndTimezone = null;
            if (txInitialDPArgWrapper instanceof TxCap2InitialDPArgWrapper) {
                timeAndTimezone = ((TxCap2InitialDPArgWrapper) txInitialDPArgWrapper).getTxTimeAndTimezone();
            }
            CalledPartyBCDNumber calledPartyBCDNumber = null;
            CallReferenceNumber callReferenceNumber = null;
            ExtBasicServiceCode extBasicServiceCode = null;
            IMSI imsi = null;
            LocationInformation locationInformation = null;
            ISDNAddressString mscAddress = null;
            if (txInitialDPArgWrapper instanceof TxCap1InitialDPArgWrapper) {
                final TxCap1InitialDPArgWrapper txCap1InitialDPArgWrapper = (TxCap1InitialDPArgWrapper) txInitialDPArgWrapper;
                calledPartyBCDNumber = txCap1InitialDPArgWrapper.getTxCalledPartyBCDNumber();
                callReferenceNumber = txCap1InitialDPArgWrapper.getTxCallReferenceNumber();
                extBasicServiceCode = txCap1InitialDPArgWrapper.getTxExtBasicServiceCode();
                imsi = txCap1InitialDPArgWrapper.getTxImsi();
                locationInformation = txCap1InitialDPArgWrapper.getTxLocationInformation();
                mscAddress = txCap1InitialDPArgWrapper.getTxMscAddress();
            }

            return dialogCircuitSwitchedCall.addInitialDPRequest(txInitialDPArgWrapper.getServiceKey(), txInitialDPArgWrapper.getTxCalledPartyNumber(),
                    txInitialDPArgWrapper.getTxCallingPartyNumber(),
                    txInitialDPArgWrapper.getTxCallingPartysCategoryInap(), null, null,
                    null, txInitialDPArgWrapper.getTxOriginalCalledPartyID(), null,
                    txInitialDPArgWrapper.getTxHighLayerCompatibility(), null, txInitialDPArgWrapper.getTxBearerCapability(),
                    txInitialDPArgWrapper.getTxEventTypeBCSM(), txInitialDPArgWrapper.getTxRedirectingPartyID(), txInitialDPArgWrapper.getTxRedirectionInformationInap(),
                    null, null, null, null,
                    null, false, imsi, null, locationInformation,
                    extBasicServiceCode, callReferenceNumber, mscAddress,
                    calledPartyBCDNumber, timeAndTimezone, false, null).intValue();

        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendEventReportBCSM(final EventReportBCSMArgWrapper eventReportBCSMArg) throws Ss7WrapperException {
        final TxEventReportBCSMArgWrapper txEventReportBCSMArgWrapper = (TxEventReportBCSMArgWrapper) eventReportBCSMArg;
        try {
            return dialogCircuitSwitchedCall.addEventReportBCSMRequest(INVOKE_TIMEOUT, txEventReportBCSMArgWrapper.getTxEventTypeBCSM(),
                    txEventReportBCSMArgWrapper.getTxEventSpecificInformationBCSM(), txEventReportBCSMArgWrapper.getTxLegID(),
                    txEventReportBCSMArgWrapper.getTxMiscCallInfo(), null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendActivityTest(final long invoke) throws Ss7WrapperException {
        try {
            dialogCircuitSwitchedCall.addActivityTestResponse(invoke);
            return (int) invoke;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendSpecializedResourceReport(final long invoke, final SpecializedResourceReportArgWrapper specializedResourceReportArg) throws Ss7WrapperException {
        try {
            return dialogCircuitSwitchedCall.addSpecializedResourceReportRequest_CapV23(invoke).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendAssistRequestInstructions(final AssistRequestInstructionsArgWrapper assistRequestInstructionsArg) throws Ss7WrapperException {
        try {
            final TxAssistRequestInstructionsArgWrapper txAssistRequestInstructionsArgWrapper = (TxAssistRequestInstructionsArgWrapper) assistRequestInstructionsArg;
            final org.mobicents.protocols.ss7.cap.api.isup.Digits correlationID;
            if (txAssistRequestInstructionsArgWrapper.getTxCorrelationID() == null) {
                correlationID = null;
            } else {
                correlationID = capProvider.getCAPParameterFactory().createDigits_GenericNumber(txAssistRequestInstructionsArgWrapper.getTxCorrelationID());
            }
            IPSSPCapabilities ipsspCapabilities = null;
            if (txAssistRequestInstructionsArgWrapper instanceof TxCap2AssistRequestInstructionsArgWrapper) {
                ipsspCapabilities = ((TxCap2AssistRequestInstructionsArgWrapper) txAssistRequestInstructionsArgWrapper).getTxIpsspCapabilities();
            }
            return dialogCircuitSwitchedCall.addAssistRequestInstructionsRequest(correlationID, ipsspCapabilities, null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendCallInformationReport(final CallInformationReportArgWrapper callInformationReportArg) throws Ss7WrapperException {
        final TxCallInformationReportArgWrapper txCallInformationReportArgWrapper = (TxCallInformationReportArgWrapper) callInformationReportArg;
        final ReceivingSideID txLegID;
        if (txCallInformationReportArgWrapper instanceof TxCap2CallInformationReportArgWrapper) {
            txLegID = ((TxCap2CallInformationReportArgWrapper) txCallInformationReportArgWrapper).getTxLegID();
        } else {
            txLegID = null;
        }
        try {
            return dialogCircuitSwitchedCall.addCallInformationReportRequest(txCallInformationReportArgWrapper.getTxRequestedInformation(),
                    null, txLegID).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendFurnishChargingInformation(final FurnishChargingInformationArgWrapper furnishChargingInformationArg) throws Ss7WrapperException {
        final TxFurnishChargingInformationArgWrapper txFurnishChargingInformationArgWrapper = (TxFurnishChargingInformationArgWrapper) furnishChargingInformationArg;

        try {
            final FCIBCCCAMELsequence1 fcibcccameLsequence1;
            if (txFurnishChargingInformationArgWrapper instanceof TxCap2FurnishChargingInformationArgWrapper) {
                fcibcccameLsequence1 = ((TxCap2FurnishChargingInformationArgWrapper) txFurnishChargingInformationArgWrapper).getTxFCIBCCCAMELsequence1();
            } else {
                fcibcccameLsequence1 = null;
            }
            return dialogCircuitSwitchedCall.addFurnishChargingInformationRequest(fcibcccameLsequence1).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
}
