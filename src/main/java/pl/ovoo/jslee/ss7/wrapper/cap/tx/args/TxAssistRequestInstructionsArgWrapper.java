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
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;
import pl.ovoo.jslee.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper;



/**
 * TxAssistRequestInstructionsArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxAssistRequestInstructionsArgWrapper implements AssistRequestInstructionsArgWrapper {

    /** The correlation id. */
    private transient GenericNumberWrapper correlationID = null;

    /** The tx correlation id. */
    private GenericNumber txCorrelationID;

    /** The generic number impl. */
    private GenericNumberImpl genericNumberImpl;

    /** The logger. */
    private static Logger logger = Logger.getLogger(TxAssistRequestInstructionsArgWrapper.class);

    /**
     * Instantiates a new tx assist request instructions arg wrapper.
     */
    public TxAssistRequestInstructionsArgWrapper() {
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper#hasCorrelationID()
     */
    @Override
    public boolean hasCorrelationID() {
        return txCorrelationID != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper#getCorrelationID()
     */
    @Override
    public GenericNumberWrapper getCorrelationID() {
        if (this.correlationID == null && this.txCorrelationID != null) {
            this.correlationID = new TxGenericNumberWrapper(txCorrelationID);
        }
        return this.correlationID;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper#setCorrelationID(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper)
     */
    @Override
    public void setCorrelationID(final GenericNumberWrapper correlationID) {
        if (correlationID == null) {
            this.txCorrelationID = null;
            this.correlationID = null;
        } else {
            final TxGenericNumberWrapper txGenericNumberWrapper = (TxGenericNumberWrapper) correlationID;
            this.txCorrelationID = txGenericNumberWrapper.getTxGenericNumber();
            this.correlationID = txGenericNumberWrapper;
        }
    }

    /**
     * Gets the tx correlation id.
     *
     * @return the tx correlation id
     */
    public GenericNumber getTxCorrelationID() {
        return txCorrelationID;
    }

    /**
     * Sets the tx correlation id.
     *
     * @param txCorrelationID the new tx correlation id
     */
    public void setTxCorrelationID(final GenericNumber txCorrelationID) {
        this.correlationID = null;
        this.txCorrelationID = txCorrelationID;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxAssistRequestInstructionsArgWrapper [txCorrelationID=" + txCorrelationID + "]";
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
        this.txCorrelationID = genericNumberImpl;
    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        genericNumberImpl = (GenericNumberImpl) txCorrelationID;

        byte encodedBytes[] = null;
        try {
            encodedBytes = genericNumberImpl.encode();
        } catch (ParameterException e) {
            logger.info(e);
            e.printStackTrace();
        }
        if(encodedBytes != null) out.writeInt(encodedBytes.length);
        out.write(encodedBytes);
    }

}
