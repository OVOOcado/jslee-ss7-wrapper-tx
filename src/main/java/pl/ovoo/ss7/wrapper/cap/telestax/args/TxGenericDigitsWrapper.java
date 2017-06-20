/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.GenericDigitsWrapper;

import java.io.UnsupportedEncodingException;

/**
 * TxGenericDigitsWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxGenericDigitsWrapper implements GenericDigitsWrapper {

	private final GenericDigits genericDigits;

	public TxGenericDigitsWrapper(final GenericDigits genericDigits) {
		this.genericDigits = genericDigits;
	}

	@Override
	public void setEncodingScheme(final EncodingScheme encodingScheme) {
		genericDigits.setEncodingScheme(encodingScheme.getValue());
	}

	@Override
	public void setTypeOfDigits(final TypeOfDigits typeOfDigits) {
		genericDigits.setTypeOfDigits(typeOfDigits.getValue());
	}

	@Override
	public void setAddress(final String address) throws Ss7WrapperException {
		try {
			genericDigits.setDecodedDigits(genericDigits.getEncodingScheme(), address);
		} catch (UnsupportedEncodingException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public EncodingScheme getEncodingScheme() {
		return EncodingScheme.valueOf(genericDigits.getEncodingScheme());
	}

	@Override
	public TypeOfDigits getTypeOfDigits() {
		return TypeOfDigits.valueOf(genericDigits.getTypeOfDigits());
	}

	@Override
	public String getAddress() throws Ss7WrapperException {
		try {
			return genericDigits.getDecodedDigits();
		} catch (UnsupportedEncodingException e) {
			throw new Ss7WrapperException(e);
		}
	}

	public GenericDigits getTxGenericDigits() {
		return genericDigits;
	}

	@Override
	public String toString() {
		return "TxGenericDigitsWrapper [genericDigits=" + genericDigits + "]";
	}

}
