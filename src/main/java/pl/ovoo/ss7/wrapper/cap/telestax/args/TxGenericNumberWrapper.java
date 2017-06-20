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

import org.mobicents.protocols.ss7.isup.ParameterException;
import org.mobicents.protocols.ss7.isup.impl.message.parameter.GenericNumberImpl;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;
import pl.ovoo.ss7.wrapper.cap.args.GenericNumberWrapper;

/**
 * OcGenericNumberWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxGenericNumberWrapper implements GenericNumberWrapper {

    private GenericNumber genericNumber;

    private GenericNumberImpl genericNumberImpl;

    public TxGenericNumberWrapper(final GenericNumber genericNumber) {
        this.genericNumber = genericNumber;
    }

    public TxGenericNumberWrapper() {
    }

    public GenericNumber getTxGenericNumber() {
        return genericNumber;
    }

    @Override
    public boolean hasAddress() {
        return genericNumber.getAddress() != null;
    }

    @Override
    public void setNature(final Nature nature) {
        genericNumber.setNatureOfAddresIndicator(nature.getValue());
    }

    @Override
    public Nature getNature() {
        return Nature.valueOf(genericNumber.getNatureOfAddressIndicator());
    }

    @Override
    public void setNumberingPlan(final NumberingPlan numberingPlan) {
        genericNumber.setNumberingPlanIndicator(numberingPlan.getValue());
    }

    @Override
    public NumberingPlan getNumberingPlan() {
        return NumberingPlan.valueOf(genericNumber.getNumberingPlanIndicator());

    }

    @Override
    public void setNumberQualifier(final NumberQualifier numberQualifier) {
        genericNumber.setNumberQualifierIndicator(numberQualifier.getValue());
    }

    @Override
    public NumberQualifier getNumberQualifier() {
        return NumberQualifier.valueOf(genericNumber.getNumberQualifierIndicator());
    }

    @Override
    public void setNumberIncomplete(final boolean numberIncomplete) {
        genericNumber.setNumberIncompleter(numberIncomplete);
    }

    @Override
    public boolean getNumberIncomplete() {
        return genericNumber.isNumberIncomplete();
    }

    @Override
    public void setScreening(final Screening screening) {
        genericNumber.setScreeningIndicator(screening.getValue());

    }

    @Override
    public Screening getScreening() {
        return Screening.valueOf(genericNumber.getScreeningIndicator());
    }

    @Override
    public void setPresentation(final Presentation presentation) {
        genericNumber.setAddressRepresentationRestrictedIndicator(presentation.getValue());

    }

    @Override
    public Presentation getPresentation() {
        return Presentation.valueOf(genericNumber.getAddressRepresentationRestrictedIndicator());
    }

    @Override
    public void setAddress(final String address) {
        genericNumber.setAddress(address);
    }

    @Override
    public String getAddress() {
        return genericNumber.getAddress();
    }

    @Override
    public String toString() {
        return "TxGenericNumberWrapper [genericNumber=" + genericNumber + "]";
    }

    @Override
    public void readExternal(ObjectInput oin) throws IOException, ClassNotFoundException {
        genericNumberImpl = new GenericNumberImpl();

        byte[] decodedBytes = new byte[oin.readInt()];
        oin.read(decodedBytes);
        try {
            genericNumberImpl.decode(decodedBytes);
        } catch (ParameterException e) {
            e.printStackTrace();
        }
        this.genericNumber = genericNumberImpl;

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        genericNumberImpl = (GenericNumberImpl) genericNumber;

        byte encodedBytes[] = null;
        try {
            encodedBytes = genericNumberImpl.encode();
        } catch (ParameterException e) {
            e.printStackTrace();
        }
        out.writeInt(encodedBytes.length);
        out.write(encodedBytes);
    }

}
