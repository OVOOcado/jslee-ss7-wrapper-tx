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

package pl.ovoo.jslee.ss7.wrapper.map.tx;

import javax.slee.ActivityContextInterface;

import org.mobicents.protocols.ss7.map.api.MAPApplicationContext;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextName;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextVersion;
import org.mobicents.protocols.ss7.map.api.MAPDialog;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.dialog.MAPDialogState;
import org.mobicents.protocols.ss7.map.api.dialog.Reason;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPErrorWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPUserAbortChoiceWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.DialogState;
import pl.ovoo.jslee.ss7.wrapper.map.MapApplicationContextWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPUserAbortChoiceWrapper;


/**
 * TxMapDialogWrapperImpl.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMapDialogWrapperImpl implements MapDialogWrapper {

    /** The activity context interface. */
    private ActivityContextInterface activityContextInterface;
    
    /** The dialog. */
    private MAPDialog dialog;

    /**
     * Instantiates a new tx map dialog wrapper impl.
     *
     * @param dialog the dialog
     */
    public TxMapDialogWrapperImpl(final MAPDialog dialog) {
        this.dialog = dialog;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#getActivityContextInterface()
     */
    @Override
    public ActivityContextInterface getActivityContextInterface() {
        return activityContextInterface;
    }

    /**
     * Sets the activity context interface.
     *
     * @param activityContextInterface the new activity context interface
     */
    public void setActivityContextInterface(final ActivityContextInterface activityContextInterface) {
        this.activityContextInterface = activityContextInterface;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#getDialogState()
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#refuseDialog()
     */
    @Override
    public void refuseDialog() throws Ss7WrapperException {
        try {
            dialog.refuse(Reason.noReasonGiven);
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#sendClose(boolean)
     */
    @Override
    public void sendClose(final boolean b) throws Ss7WrapperException {
        try {
            dialog.close(b);
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#sendUserAbort(pl.ovoo.jslee.ss7.wrapper.map.args.MAPUserAbortChoiceWrapper)
     */
    @Override
    public void sendUserAbort(MAPUserAbortChoiceWrapper mAPUserAbortChoiceWrapper) throws Ss7WrapperException {
        try {
            dialog.abort(((TxMAPUserAbortChoiceWrapper)mAPUserAbortChoiceWrapper).getTxMAPUserAbortChoice());
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#sendDelimiter()
     */
    @Override
    public void sendDelimiter() throws Ss7WrapperException {
        try {
        	dialog.send();
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#getDialogID()
     */
    @Override
    public String getDialogID(){
    	return dialog.getLocalDialogId().toString();
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#acceptDialog()
     */
    @Override
    public void acceptDialog() throws Ss7WrapperException {

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#getApplicationContext()
     */
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
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper#sendError(long, pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorWrapper)
     */
    @Override
    public void sendError(long invoke, MAPErrorWrapper mAPErrorWrapper) throws Ss7WrapperException {
    	try {
			dialog.sendErrorComponent(invoke, ((TxMAPErrorWrapper)mAPErrorWrapper).getTxMAPErrorMessage());
		} catch (MAPException e) {
            throw new Ss7WrapperException(e);
		}
    }
}
