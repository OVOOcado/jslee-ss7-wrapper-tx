/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.apache.log4j.Logger;
import org.mobicents.protocols.ss7.isup.ParameterException;
import org.mobicents.protocols.ss7.isup.impl.message.parameter.GenericNumberImpl;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;
import pl.ovoo.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.GenericDigitsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.GenericNumberWrapper;

/**
 * TxEstablishTemporaryConnectionArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEstablishTemporaryConnectionArgWrapper implements EstablishTemporaryConnectionArgWrapper {

    private transient GenericNumberWrapper assistingSSPIPRoutingAddress = null;
    private transient GenericDigitsWrapper assistingDialogCorrelationID = null;

    private GenericNumber txAssistingSSPIPRoutingAddress;
    private GenericDigits txAssistingDialogCorrelationID;

    private GenericNumberImpl genericNumberImpl;

    private Logger logger = Logger.getLogger(TxEstablishTemporaryConnectionArgWrapper.class);

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

    @Override
    public GenericNumberWrapper getAssistingSSPIPRoutingAddress() {
        if (this.assistingSSPIPRoutingAddress == null && this.txAssistingSSPIPRoutingAddress != null) {
            this.assistingSSPIPRoutingAddress = new TxGenericNumberWrapper(txAssistingSSPIPRoutingAddress);
        }
        return this.assistingSSPIPRoutingAddress;
    }

    public GenericDigitsWrapper getAssistingDialogCorrelationID() {
        if (this.assistingDialogCorrelationID == null && this.txAssistingDialogCorrelationID != null) {
            this.assistingDialogCorrelationID = new TxGenericDigitsWrapper(txAssistingDialogCorrelationID);
        }
        return this.assistingDialogCorrelationID;
    }

    public GenericNumber getTxAssistingSSPIPRoutingAddress() {
        return txAssistingSSPIPRoutingAddress;
    }

    public void setTxAssistingSSPIPRoutingAddress(final GenericNumber txAssistingSSPIPRoutingAddress) {
        this.txAssistingSSPIPRoutingAddress = txAssistingSSPIPRoutingAddress;
        this.assistingSSPIPRoutingAddress = null;
    }

    public GenericDigits getTxAssistingDialogCorrelationID() {
        return txAssistingDialogCorrelationID;
    }

    public void setTxAssistingDialogCorrelationID(final GenericDigits txAssistingDialogCorrelationID) {
        this.txAssistingDialogCorrelationID = txAssistingDialogCorrelationID;
        this.assistingDialogCorrelationID = null;
    }

    @Override
    public String toString() {
        return "TxEstablishTemporaryConnectionArgWrapper [txAssistingSSPIPRoutingAddress="
                + txAssistingSSPIPRoutingAddress + ", txAssistingDialogCorrelationID=" + txAssistingDialogCorrelationID
                + "]";
    }

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
