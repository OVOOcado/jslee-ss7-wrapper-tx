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

package pl.ovoo.jslee.ss7.wrapper.cap.tx;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.sms.CAPDialogSms;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSEvent;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.SmsCapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeSMS;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SMSEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxConnectSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxEventReportSMSArgWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxInitialDPSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxRPCauseWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxReleaseSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxSMSEventWrapper;

import java.util.ArrayList;


/**
 * TxSmsCapDialogWrapperImpl.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxSmsCapDialogWrapperImpl extends TxCapDialogWrapperImpl implements SmsCapDialogWrapper {

    /** The cap dialog sms. */
    private final CAPDialogSms capDialogSms;

    /**
     * Instantiates a new tx sms cap dialog wrapper impl.
     *
     * @param capDialogSms the cap dialog sms
     */
    public TxSmsCapDialogWrapperImpl(final CAPDialogSms capDialogSms) {
        super(capDialogSms);
        this.capDialogSms = capDialogSms;
    }


    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.SmsCapDialogWrapper#sendReleaseSMS(pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseSMSArgWrapper)
     */
    @Override
    public int sendReleaseSMS(final ReleaseSMSArgWrapper releaseSMSArg) throws Ss7WrapperException {
        final TxReleaseSMSArgWrapper txReleaseSMSArg = (TxReleaseSMSArgWrapper) releaseSMSArg;
        final TxRPCauseWrapperImpl txRpCause = (TxRPCauseWrapperImpl)txReleaseSMSArg.getRPCause();
        try {
            return capDialogSms.addReleaseSMSRequest(txRpCause.getTxRpCause()).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.SmsCapDialogWrapper#sendRequestReportSMSEvent(pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper)
     */
    @Override
    public int sendRequestReportSMSEvent(final RequestReportSMSEventArgWrapper cap3RequestReportSMSEventArg) throws Ss7WrapperException {
        final ArrayList<SMSEvent> smsEventWrappers = new ArrayList<SMSEvent>(cap3RequestReportSMSEventArg.getSMSEvents().length);
        for (final SMSEventWrapper smsEventWrapper : cap3RequestReportSMSEventArg.getSMSEvents()){
            final TxSMSEventWrapper txSMSEventWrapper = (TxSMSEventWrapper) smsEventWrapper;
            smsEventWrappers.add(txSMSEventWrapper.getSMSEvent());
        }
        try {
            return capDialogSms.addRequestReportSMSEventRequest(smsEventWrappers, null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.SmsCapDialogWrapper#sendConnectSMS(pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper)
     */
    @Override
    public int sendConnectSMS(final ConnectSMSArgWrapper cap3ConnectSMSArg) throws Ss7WrapperException {
    	try {
    		TxConnectSMSArgWrapper txCap3ConnectSMSArg = (TxConnectSMSArgWrapper)cap3ConnectSMSArg;
    		return capDialogSms.addConnectSMSRequest(null,
    				txCap3ConnectSMSArg.getTxDestinationSubscriberNumber(),
    				txCap3ConnectSMSArg.getTxSmscAddress(), null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.SmsCapDialogWrapper#sendInitialDPSMS(pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper)
     */
    @Override
    public int sendInitialDPSMS(final InitialDPSMSArgWrapper initialDPSMSArg) throws Ss7WrapperException {
        try {
            final TxInitialDPSMSArgWrapper txInitialDPSMSArgWrapper = (TxInitialDPSMSArgWrapper) initialDPSMSArg;

            return capDialogSms.addInitialDPSMSRequest(txInitialDPSMSArgWrapper.getServiceKey(), 
            		txInitialDPSMSArgWrapper.getTxDestinationSubscriberNumber(),
            		txInitialDPSMSArgWrapper.getTxCallingPartyNumber(),
            		txInitialDPSMSArgWrapper.getTxEventTypeSMS(), 
            		txInitialDPSMSArgWrapper.getTxImsi(),
            		txInitialDPSMSArgWrapper.getTxLocationInformationMSC(),
            		null,
            		txInitialDPSMSArgWrapper.getTxSmscAddress(),
            		txInitialDPSMSArgWrapper.getTxTimeAndTimezone(),
            		null,null,null,null,null,
            		txInitialDPSMSArgWrapper.getTxSmsReferenceNumber(),
            		txInitialDPSMSArgWrapper.getTxMscAddress(),
            		null,null,null,null,null).intValue();

        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.SmsCapDialogWrapper#sendContinueSMS()
     */
    @Override
    public int sendContinueSMS() throws Ss7WrapperException {
    	try {
			return capDialogSms.addContinueSMSRequest().intValue();
		} catch (CAPException e) {
            throw new Ss7WrapperException(e);
		}
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.SmsCapDialogWrapper#sendEventReportSMS(pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper)
     */
    @Override
    public int sendEventReportSMS(EventReportSMSArgWrapper eventReportSMSArgWrapper) throws Ss7WrapperException {
    	final TxEventReportSMSArgWrapperImpl txeventReportSMSArgWrapper = (TxEventReportSMSArgWrapperImpl) eventReportSMSArgWrapper;
    	final EventTypeSMS eventTypeSMS = txeventReportSMSArgWrapper.getEventTypeSMS();
        try {
			return capDialogSms.addEventReportSMSRequest(
					org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS.getInstance(eventTypeSMS.getValue()),
					null, null, null).intValue();
		} catch (CAPException e) {
            throw new Ss7WrapperException(e);
		}
    }
}
