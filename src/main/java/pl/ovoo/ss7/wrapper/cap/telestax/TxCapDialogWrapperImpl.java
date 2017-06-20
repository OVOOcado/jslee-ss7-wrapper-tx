/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax;

import org.mobicents.protocols.ss7.cap.api.CAPApplicationContext;
import org.mobicents.protocols.ss7.cap.api.CAPDialog;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.dialog.CAPDialogState;
import org.mobicents.protocols.ss7.cap.api.dialog.CAPUserAbortReason;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.ApplicationContextWrapper;
import pl.ovoo.ss7.wrapper.cap.CapDialogWrapper;
import pl.ovoo.ss7.wrapper.cap.DialogState;

import javax.slee.ActivityContextInterface;

/**
 * TxCapDialogWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCapDialogWrapperImpl implements CapDialogWrapper {

    private ActivityContextInterface activityContextInterface;
    private CAPDialog dialog;

    public TxCapDialogWrapperImpl(final CAPDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public ActivityContextInterface getActivityContextInterface() {
        return activityContextInterface;
    }

    public void setActivityContextInterface(final ActivityContextInterface activityContextInterface) {
        this.activityContextInterface = activityContextInterface;
    }

    @Override
    public DialogState getDialogState() {
        final CAPDialogState state = dialog.getState();
        if (state == null) {
            return null;
        }
        switch (state) {
            case Idle:
                return DialogState.IDLE;
            case Active:
                return DialogState.ACTIVE;
            case Expunged:
                return null;
            case InitialSent:
                return DialogState.INIT_SENT;
            case InitialReceived:
                return DialogState.INIT_RECEIVED;
            default:
                return null;
        }
    }

    @Override
    public void refuseDialog() throws Ss7WrapperException {
        try {
            dialog.abort(CAPUserAbortReason.no_reason_given);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public void sendClose(final boolean b) throws Ss7WrapperException {
        try {
            dialog.close(b);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public void sendUserAbort() throws Ss7WrapperException {
        try {
            dialog.abort(CAPUserAbortReason.no_reason_given);;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public void sendDelimiter() throws Ss7WrapperException {
        try {
            dialog.send();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
    
    @Override
    public String getDialogID(){
    	return dialog.getLocalDialogId().toString();
    }
    
    @Override
    public void acceptDialog() throws Ss7WrapperException {

    }

    @Override
    public ApplicationContextWrapper getApplicationContext() {
    	final CAPApplicationContext ac = dialog.getApplicationContext();
        if (ac == null) {
            return null;
        }
        if (ac.equals(CAPApplicationContext.CapV1_gsmSSF_to_gsmSCF)) {
        	return ApplicationContextWrapper.cap_v1_gsmSSF_to_gsmSCF_AC;
        }
        else if (ac.equals(CAPApplicationContext.CapV2_gsmSSF_to_gsmSCF)) {
        	return ApplicationContextWrapper.cap_v2_gsmSSF_to_gsmSCF_AC;
        }
        else if (ac.equals(CAPApplicationContext.CapV2_gsmSRF_to_gsmSCF)) {
        	return ApplicationContextWrapper.cap_v2_gsmSRF_to_gsmSCF_AC;
        }
        else if (ac.equals(CAPApplicationContext.CapV3_gsmSSF_scfGeneric)) {
        	return ApplicationContextWrapper.cap_v3_capssf_scfGenericAC;
        }
        else if (ac.equals(CAPApplicationContext.CapV3_cap3_sms)) {
        	return ApplicationContextWrapper.cap_v3_cap3_sms_AC;
        }
        else if (ac.equals(CAPApplicationContext.CapV3_gsmSRF_gsmSCF)) {
        	return ApplicationContextWrapper.gsmSRF_gsmSCF_ac;
        }
        return null;
    }
}
