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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.protocols.ss7.cap.api.CAPDialog;
import org.mobicents.protocols.ss7.cap.api.CAPMessage;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CAPDialogCircuitSwitchedCall;
import org.mobicents.protocols.ss7.cap.api.service.sms.CAPDialogSms;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxCapDialogWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.cap.CapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.EventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxCap1CallCapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxCap2CallCapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.TxSmsCapDialogWrapperImpl;

import javax.slee.ActivityContextInterface;


/**
 * OcEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventWrapper implements EventWrapper {

    /** The aci. */
    private final ActivityContextInterface aci;
    
    /** The dialog. */
    private final CAPDialog dialog;
    
    /** The cap message. */
    //private CAPProvider capProvider;
    private final CAPMessage capMessage;

    /**
     * Instantiates a new tx event wrapper.
     *
     * @param aci the aci
     * @param capMessage the cap message
     */
    public TxEventWrapper(final ActivityContextInterface aci, CAPMessage capMessage) {
        this.aci = aci;
        this.dialog = (CAPDialog) aci.getActivity();
        this.capMessage = capMessage;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.event.EventWrapper#getDialog()
     */
    @Override
    public CapDialogWrapper getDialog() {
        return createCallCapDialogWrapper();
    }

    /**
     * Creates the call cap dialog wrapper.
     *
     * @return the cap dialog wrapper
     */
    private CapDialogWrapper createCallCapDialogWrapper() {
        if (dialog instanceof CAPDialogCircuitSwitchedCall) {
            final TxCapDialogWrapperImpl txCap1CallCapDialogWrapper;

            switch (dialog.getApplicationContext()) {
                case CapV1_gsmSSF_to_gsmSCF:
                    //txCap1CallCapDialogWrapper = new TxCap1CallCapDialogWrapper((CAPDialogCircuitSwitchedCall) dialog, capProvider);
                    txCap1CallCapDialogWrapper = new TxCap1CallCapDialogWrapper((CAPDialogCircuitSwitchedCall) dialog, null);
                    break;
                default:
                    //txCap1CallCapDialogWrapper = new TxCap2CallCapDialogWrapper((CAPDialogCircuitSwitchedCall) dialog, capProvider);
                    txCap1CallCapDialogWrapper = new TxCap2CallCapDialogWrapper((CAPDialogCircuitSwitchedCall) dialog, null);

            }
            txCap1CallCapDialogWrapper.setActivityContextInterface(aci);
            return txCap1CallCapDialogWrapper;
        }
        else if (dialog instanceof CAPDialogSms) {
            final TxSmsCapDialogWrapperImpl txSmsCapDialogWrapperImpl;

            switch (dialog.getApplicationContext()) {
                case CapV3_cap3_sms:
                	txSmsCapDialogWrapperImpl = new TxSmsCapDialogWrapperImpl((CAPDialogSms) dialog);
                    break;
                default:
                	txSmsCapDialogWrapperImpl = new TxSmsCapDialogWrapperImpl((CAPDialogSms) dialog);

            }
            txSmsCapDialogWrapperImpl.setActivityContextInterface(aci);
            return txSmsCapDialogWrapperImpl;
        }

        return null;
    }

    /**
     * Gets the tx dialog.
     *
     * @return the tx dialog
     */
    protected CAPDialog getTxDialog() {
        return dialog;
    }

    /**
     * Gets the aci.
     *
     * @return the aci
     */
    protected ActivityContextInterface getAci() {
        return aci;
    }

    /**
     * Gets the cap message.
     *
     * @return the cap message
     */
    public CAPMessage getCapMessage() {
        return capMessage;
    }
}
