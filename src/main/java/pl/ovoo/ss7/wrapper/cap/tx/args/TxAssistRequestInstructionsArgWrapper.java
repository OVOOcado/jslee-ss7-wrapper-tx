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

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.apache.log4j.Logger;
import org.mobicents.protocols.ss7.isup.ParameterException;
import org.mobicents.protocols.ss7.isup.impl.message.parameter.GenericNumberImpl;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;
import pl.ovoo.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.GenericNumberWrapper;


/**
 * TxAssistRequestInstructionsArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxAssistRequestInstructionsArgWrapper implements AssistRequestInstructionsArgWrapper {

    private transient GenericNumberWrapper correlationID = null;

    private GenericNumber txCorrelationID;

    private GenericNumberImpl genericNumberImpl;

    private static Logger logger = Logger.getLogger(TxAssistRequestInstructionsArgWrapper.class);

    public TxAssistRequestInstructionsArgWrapper() {
    }

    @Override
    public boolean hasCorrelationID() {
        return txCorrelationID != null;
    }

    @Override
    public GenericNumberWrapper getCorrelationID() {
        if (this.correlationID == null && this.txCorrelationID != null) {
            this.correlationID = new TxGenericNumberWrapper(txCorrelationID);
        }
        return this.correlationID;
    }

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

    public GenericNumber getTxCorrelationID() {
        return txCorrelationID;
    }

    public void setTxCorrelationID(final GenericNumber txCorrelationID) {
        this.correlationID = null;
        this.txCorrelationID = txCorrelationID;
    }

    @Override
    public String toString() {
        return "TxAssistRequestInstructionsArgWrapper [txCorrelationID=" + txCorrelationID + "]";
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
        this.txCorrelationID = genericNumberImpl;
    }

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
