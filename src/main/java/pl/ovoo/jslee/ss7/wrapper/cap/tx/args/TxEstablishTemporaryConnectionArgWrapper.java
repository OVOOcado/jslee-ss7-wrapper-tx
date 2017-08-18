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

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.apache.log4j.Logger;
import org.mobicents.protocols.ss7.isup.ParameterException;
import org.mobicents.protocols.ss7.isup.impl.message.parameter.GenericNumberImpl;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericDigitsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper;


/**
 * TxEstablishTemporaryConnectionArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEstablishTemporaryConnectionArgWrapper implements EstablishTemporaryConnectionArgWrapper {

    /** The assisting sspip routing address. */
    private transient GenericNumberWrapper assistingSSPIPRoutingAddress = null;
    
    /** The assisting dialog correlation id. */
    private transient GenericDigitsWrapper assistingDialogCorrelationID = null;

    /** The tx assisting sspip routing address. */
    private GenericNumber txAssistingSSPIPRoutingAddress;
    
    /** The tx assisting dialog correlation id. */
    private GenericDigits txAssistingDialogCorrelationID;

    /** The generic number impl. */
    private GenericNumberImpl genericNumberImpl;

    /** The logger. */
    private static Logger logger = Logger.getLogger(TxEstablishTemporaryConnectionArgWrapper.class);

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper#setAssistingSSPIPRoutingAddress(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper)
     */
    @Override
    public void setAssistingSSPIPRoutingAddress(final GenericNumberWrapper assistingSSPIPRoutingAddress) {
        if (assistingSSPIPRoutingAddress == null) {
            this.txAssistingSSPIPRoutingAddress = null;
            this.assistingSSPIPRoutingAddress = null;
        } else {
            final TxGenericNumberWrapper txGenericNumberWrapper = (TxGenericNumberWrapper) assistingSSPIPRoutingAddress;
            this.txAssistingSSPIPRoutingAddress = txGenericNumberWrapper.getTxGenericNumber();
            this.assistingSSPIPRoutingAddress = txGenericNumberWrapper;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper#setAssistingDialogCorrelationID(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericDigitsWrapper)
     */
    @Override
    public void setAssistingDialogCorrelationID(final GenericDigitsWrapper cginAssistingDialogCorrelationID) {
        if (cginAssistingDialogCorrelationID == null) {
            this.txAssistingDialogCorrelationID = null;
            this.assistingDialogCorrelationID = null;
        } else {
            final TxGenericDigitsWrapper txGenericDigitsWrapper = (TxGenericDigitsWrapper) cginAssistingDialogCorrelationID;
            this.txAssistingDialogCorrelationID = txGenericDigitsWrapper.getTxGenericDigits();
            this.assistingDialogCorrelationID = txGenericDigitsWrapper;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper#getAssistingSSPIPRoutingAddress()
     */
    @Override
    public GenericNumberWrapper getAssistingSSPIPRoutingAddress() {
        if (this.assistingSSPIPRoutingAddress == null && this.txAssistingSSPIPRoutingAddress != null) {
            this.assistingSSPIPRoutingAddress = new TxGenericNumberWrapper(txAssistingSSPIPRoutingAddress);
        }
        return this.assistingSSPIPRoutingAddress;
    }

    /**
     * Gets the assisting dialog correlation id.
     *
     * @return the assisting dialog correlation id
     */
    public GenericDigitsWrapper getAssistingDialogCorrelationID() {
        if (this.assistingDialogCorrelationID == null && this.txAssistingDialogCorrelationID != null) {
            this.assistingDialogCorrelationID = new TxGenericDigitsWrapper(txAssistingDialogCorrelationID);
        }
        return this.assistingDialogCorrelationID;
    }

    /**
     * Gets the tx assisting sspip routing address.
     *
     * @return the tx assisting sspip routing address
     */
    public GenericNumber getTxAssistingSSPIPRoutingAddress() {
        return txAssistingSSPIPRoutingAddress;
    }

    /**
     * Sets the tx assisting sspip routing address.
     *
     * @param txAssistingSSPIPRoutingAddress the new tx assisting sspip routing address
     */
    public void setTxAssistingSSPIPRoutingAddress(final GenericNumber txAssistingSSPIPRoutingAddress) {
        this.txAssistingSSPIPRoutingAddress = txAssistingSSPIPRoutingAddress;
        this.assistingSSPIPRoutingAddress = null;
    }

    /**
     * Gets the tx assisting dialog correlation id.
     *
     * @return the tx assisting dialog correlation id
     */
    public GenericDigits getTxAssistingDialogCorrelationID() {
        return txAssistingDialogCorrelationID;
    }

    /**
     * Sets the tx assisting dialog correlation id.
     *
     * @param txAssistingDialogCorrelationID the new tx assisting dialog correlation id
     */
    public void setTxAssistingDialogCorrelationID(final GenericDigits txAssistingDialogCorrelationID) {
        this.txAssistingDialogCorrelationID = txAssistingDialogCorrelationID;
        this.assistingDialogCorrelationID = null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxEstablishTemporaryConnectionArgWrapper [txAssistingSSPIPRoutingAddress="
                + txAssistingSSPIPRoutingAddress + ", txAssistingDialogCorrelationID=" + txAssistingDialogCorrelationID
                + "]";
    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
     */
    @Override
    public void readExternal(ObjectInput oin) throws IOException, ClassNotFoundException {
        genericNumberImpl = new GenericNumberImpl();

        byte[] decodedBytes = new byte[oin.readInt()];
        oin.read(decodedBytes);
        try {
            genericNumberImpl.decode(decodedBytes);
        } catch (ParameterException e) {
            logger.info(e);
            e.printStackTrace();
        }
        this.txAssistingSSPIPRoutingAddress = genericNumberImpl;
        this.txAssistingDialogCorrelationID = (GenericDigits) oin.readObject();

    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        genericNumberImpl = (GenericNumberImpl) txAssistingSSPIPRoutingAddress;

        byte encodedBytes[] = null;
        try {
            encodedBytes = genericNumberImpl.encode();
        } catch (ParameterException e) {
            logger.info(e);
            e.printStackTrace();
        }
        if(encodedBytes != null) out.writeInt(encodedBytes.length);
        out.write(encodedBytes);
        out.writeObject(txAssistingDialogCorrelationID);
    }

}
