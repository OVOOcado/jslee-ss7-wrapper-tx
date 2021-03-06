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

import javax.slee.ActivityContextInterface;

import org.mobicents.protocols.ss7.cap.api.CAPApplicationContext;
import org.mobicents.protocols.ss7.cap.api.CAPDialog;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.dialog.CAPDialogState;
import org.mobicents.protocols.ss7.cap.api.dialog.CAPUserAbortReason;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.ApplicationContextWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.DialogState;
import pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxSccpAddressWrapperImpl;

/**
 * TxCapDialogWrapperImpl.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCapDialogWrapperImpl implements CapDialogWrapper {

    /** The activity context interface. */
    private ActivityContextInterface activityContextInterface;

    /** The dialog. */
    private CAPDialog dialog;

    /**
     * Instantiates a new tx cap dialog wrapper impl.
     *
     * @param dialog
     *            the dialog
     */
    public TxCapDialogWrapperImpl(final CAPDialog dialog) {
        this.dialog = dialog;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#
     * getActivityContextInterface()
     */
    @Override
    public ActivityContextInterface getActivityContextInterface() {
        return activityContextInterface;
    }

    /**
     * Sets the activity context interface.
     *
     * @param activityContextInterface
     *            the new activity context interface
     */
    public void setActivityContextInterface(final ActivityContextInterface activityContextInterface) {
        this.activityContextInterface = activityContextInterface;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#getDialogState()
     */
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

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#refuseDialog()
     */
    @Override
    public void refuseDialog() throws Ss7WrapperException {
        try {
            dialog.abort(CAPUserAbortReason.no_reason_given);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#sendClose(boolean)
     */
    @Override
    public void sendClose(final boolean b) throws Ss7WrapperException {
        try {
            dialog.close(b);
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#sendUserAbort()
     */
    @Override
    public void sendUserAbort() throws Ss7WrapperException {
        try {
            dialog.abort(CAPUserAbortReason.no_reason_given);
            ;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#sendDelimiter()
     */
    @Override
    public void sendDelimiter() throws Ss7WrapperException {
        try {
            dialog.send();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#getDialogID()
     */
    @Override
    public String getDialogID() {
        return dialog.getLocalDialogId().toString();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#getRemoteDialogID()
     */
    @Override
    public Long getRemoteDialogID() {
        return dialog.getRemoteDialogId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#acceptDialog()
     */
    @Override
    public void acceptDialog() throws Ss7WrapperException {

    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#release()
     */
    @Override
    public void release() throws Ss7WrapperException {
        dialog.release();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper#getApplicationContext()
     */
    @Override
    public ApplicationContextWrapper getApplicationContext() {
        final CAPApplicationContext ac = dialog.getApplicationContext();
        if (ac == null) {
            return null;
        }
        if (ac.equals(CAPApplicationContext.CapV1_gsmSSF_to_gsmSCF)) {
            return ApplicationContextWrapper.cap_v1_gsmSSF_to_gsmSCF_AC;
        } else if (ac.equals(CAPApplicationContext.CapV2_gsmSSF_to_gsmSCF)) {
            return ApplicationContextWrapper.cap_v2_gsmSSF_to_gsmSCF_AC;
        } else if (ac.equals(CAPApplicationContext.CapV2_gsmSRF_to_gsmSCF)) {
            return ApplicationContextWrapper.cap_v2_gsmSRF_to_gsmSCF_AC;
        } else if (ac.equals(CAPApplicationContext.CapV3_gsmSSF_scfGeneric)) {
            return ApplicationContextWrapper.cap_v3_capssf_scfGenericAC;
        } else if (ac.equals(CAPApplicationContext.CapV3_cap3_sms)) {
            return ApplicationContextWrapper.cap_v3_cap3_sms_AC;
        } else if (ac.equals(CAPApplicationContext.CapV3_gsmSRF_gsmSCF)) {
            return ApplicationContextWrapper.gsmSRF_gsmSCF_ac;
        }
        return null;
    }

    @Override
    public SccpAddressWrapper getRemoteSccpAddress() {
        if (dialog != null && dialog.getRemoteAddress() != null) {
            return new TxSccpAddressWrapperImpl(dialog.getRemoteAddress());
        }
        return null;
    }

    @Override
    public SccpAddressWrapper getLocalSccpAddress() {
        if (dialog != null && dialog.getLocalAddress() != null) {
            return new TxSccpAddressWrapperImpl(dialog.getLocalAddress());
        }
        return null;
    }

}
