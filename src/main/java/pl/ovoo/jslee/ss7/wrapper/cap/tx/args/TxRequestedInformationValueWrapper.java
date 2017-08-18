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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationValueWrapper;


/**
 * TxRequestedInformationValueWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestedInformationValueWrapper implements RequestedInformationValueWrapper {

	/** The requested information value. */
	private final RequestedInformation requestedInformationValue;

	/**
	 * Instantiates a new tx requested information value wrapper.
	 *
	 * @param requestedInformationValue the requested information value
	 */
	public TxRequestedInformationValueWrapper(final RequestedInformation requestedInformationValue) {
		this.requestedInformationValue = requestedInformationValue;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationValueWrapper#isCallConnectedElapsedTimeValueChosen()
	 */
	@Override
	public boolean isCallConnectedElapsedTimeValueChosen() {
		return requestedInformationValue.getCallConnectedElapsedTimeValue() != null
				&& RequestedInformationType.callConnectedElapsedTime
						.equals(requestedInformationValue.getRequestedInformationType());
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationValueWrapper#getCallConnectedElapsedTimeValue()
	 */
	@Override
	public Integer getCallConnectedElapsedTimeValue() {
		if (requestedInformationValue.getCallConnectedElapsedTimeValue() != null
				&& RequestedInformationType.callConnectedElapsedTime
						.equals(requestedInformationValue.getRequestedInformationType())) {
			return requestedInformationValue.getCallConnectedElapsedTimeValue();
		}
		return null;
	}

	/**
	 * Gets the tx requested information value.
	 *
	 * @return the tx requested information value
	 */
	public RequestedInformation getTxRequestedInformationValue() {
		return requestedInformationValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxRequestedInformationValueWrapper [requestedInformationValue=" + requestedInformationValue + "]";
	}

}
