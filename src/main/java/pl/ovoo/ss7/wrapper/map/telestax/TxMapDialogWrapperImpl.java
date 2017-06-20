/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax;

import javax.slee.ActivityContextInterface;

import org.mobicents.protocols.ss7.map.api.MAPApplicationContext;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextName;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextVersion;
import org.mobicents.protocols.ss7.map.api.MAPDialog;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.dialog.MAPDialogState;
import org.mobicents.protocols.ss7.map.api.dialog.Reason;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.DialogState;
import pl.ovoo.ss7.wrapper.map.MapApplicationContextWrapper;
import pl.ovoo.ss7.wrapper.map.MapDialogWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPErrorWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPUserAbortChoiceWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPErrorWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPUserAbortChoiceWrapper;

/**
 * TxMapDialogWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMapDialogWrapperImpl implements MapDialogWrapper {

    private ActivityContextInterface activityContextInterface;
    private MAPDialog dialog;

    public TxMapDialogWrapperImpl(final MAPDialog dialog) {
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
        final MAPDialogState state = dialog.getState();
        if (state == null) {
            return null;
        }
        switch (state) {
            case IDLE:
                return DialogState.IDLE;
            case ACTIVE:
                return DialogState.ACTIVE;
            case EXPUNGED:
                return null;
            case INITIAL_SENT:
                return DialogState.INIT_SENT;
            case INITIAL_RECEIVED:
                return DialogState.INIT_RECEIVED;
            default:
                return null;
        }
    }

    @Override
    public void refuseDialog() throws Ss7WrapperException {
        try {
            dialog.refuse(Reason.noReasonGiven);
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public void sendClose(final boolean b) throws Ss7WrapperException {
        try {
            dialog.close(b);
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public void sendUserAbort(MAPUserAbortChoiceWrapper mAPUserAbortChoiceWrapper) throws Ss7WrapperException {
        try {
            dialog.abort(((TxMAPUserAbortChoiceWrapper)mAPUserAbortChoiceWrapper).getTxMAPUserAbortChoice());
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public void sendDelimiter() throws Ss7WrapperException {
        try {
        	dialog.send();
        } catch (MAPException e) {
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
    public MapApplicationContextWrapper getApplicationContext() {
    	final MAPApplicationContext ac = dialog.getApplicationContext();
        if (ac == null) {
            return null;
        }
        if (ac.equals(MAPApplicationContext.getInstance(MAPApplicationContextName.anyTimeEnquiryContext,
                MAPApplicationContextVersion.version3))) {
        	return MapApplicationContextWrapper.anyTimeInfoEnquiryContext_v3_ac;
        }
        else if (ac.equals(MAPApplicationContext.getInstance(MAPApplicationContextName.anyTimeInfoHandlingContext,
                MAPApplicationContextVersion.version3))) {
        	return MapApplicationContextWrapper.anyTimeInfoHandlingContext_v3_ac;
        }
        else if (ac.equals(MAPApplicationContext.getInstance(MAPApplicationContextName.subscriberDataMngtContext,
                MAPApplicationContextVersion.version2))) {
        	return MapApplicationContextWrapper.subscriberDataMngtContext_v2_ac;
        }
        return null;
    }
    
    @Override
    public void sendError(long invoke, MAPErrorWrapper mAPErrorWrapper) throws Ss7WrapperException {
    	try {
			dialog.sendErrorComponent(invoke, ((TxMAPErrorWrapper)mAPErrorWrapper).getTxMAPErrorMessage());
		} catch (MAPException e) {
            throw new Ss7WrapperException(e);
		}
    }
}
