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

package pl.ovoo.ss7.wrapper.cap.tx.args;

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
