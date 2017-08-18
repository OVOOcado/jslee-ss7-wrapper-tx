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
import pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper;


/**
 * OcGenericNumberWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxGenericNumberWrapper implements GenericNumberWrapper {

    /** The generic number. */
    private GenericNumber genericNumber;

    /** The generic number impl. */
    private GenericNumberImpl genericNumberImpl;

    /** The logger. */
    private static Logger logger = Logger.getLogger(TxGenericNumberWrapper.class);

    /**
     * Instantiates a new tx generic number wrapper.
     *
     * @param genericNumber the generic number
     */
    public TxGenericNumberWrapper(final GenericNumber genericNumber) {
        this.genericNumber = genericNumber;
    }

    /**
     * Instantiates a new tx generic number wrapper.
     */
    public TxGenericNumberWrapper() {
    }

    /**
     * Gets the tx generic number.
     *
     * @return the tx generic number
     */
    public GenericNumber getTxGenericNumber() {
        return genericNumber;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#hasAddress()
     */
    @Override
    public boolean hasAddress() {
        return genericNumber.getAddress() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#setNature(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper.Nature)
     */
    @Override
    public void setNature(final Nature nature) {
        genericNumber.setNatureOfAddresIndicator(nature.getValue());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#getNature()
     */
    @Override
    public Nature getNature() {
        return Nature.valueOf(genericNumber.getNatureOfAddressIndicator());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#setNumberingPlan(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper.NumberingPlan)
     */
    @Override
    public void setNumberingPlan(final NumberingPlan numberingPlan) {
        genericNumber.setNumberingPlanIndicator(numberingPlan.getValue());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#getNumberingPlan()
     */
    @Override
    public NumberingPlan getNumberingPlan() {
        return NumberingPlan.valueOf(genericNumber.getNumberingPlanIndicator());

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#setNumberQualifier(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper.NumberQualifier)
     */
    @Override
    public void setNumberQualifier(final NumberQualifier numberQualifier) {
        genericNumber.setNumberQualifierIndicator(numberQualifier.getValue());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#getNumberQualifier()
     */
    @Override
    public NumberQualifier getNumberQualifier() {
        return NumberQualifier.valueOf(genericNumber.getNumberQualifierIndicator());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#setNumberIncomplete(boolean)
     */
    @Override
    public void setNumberIncomplete(final boolean numberIncomplete) {
        genericNumber.setNumberIncompleter(numberIncomplete);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#getNumberIncomplete()
     */
    @Override
    public boolean getNumberIncomplete() {
        return genericNumber.isNumberIncomplete();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#setScreening(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper.Screening)
     */
    @Override
    public void setScreening(final Screening screening) {
        genericNumber.setScreeningIndicator(screening.getValue());

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#getScreening()
     */
    @Override
    public Screening getScreening() {
        return Screening.valueOf(genericNumber.getScreeningIndicator());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#setPresentation(pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper.Presentation)
     */
    @Override
    public void setPresentation(final Presentation presentation) {
        genericNumber.setAddressRepresentationRestrictedIndicator(presentation.getValue());

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#getPresentation()
     */
    @Override
    public Presentation getPresentation() {
        return Presentation.valueOf(genericNumber.getAddressRepresentationRestrictedIndicator());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#setAddress(java.lang.String)
     */
    @Override
    public void setAddress(final String address) {
        genericNumber.setAddress(address);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.GenericNumberWrapper#getAddress()
     */
    @Override
    public String getAddress() {
        return genericNumber.getAddress();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxGenericNumberWrapper [genericNumber=" + genericNumber + "]";
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
        this.genericNumber = genericNumberImpl;

    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        genericNumberImpl = (GenericNumberImpl) genericNumber;

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
