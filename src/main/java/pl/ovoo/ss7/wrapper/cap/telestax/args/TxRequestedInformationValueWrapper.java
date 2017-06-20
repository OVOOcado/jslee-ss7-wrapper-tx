/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationValueWrapper;

/**
 * TxRequestedInformationValueWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestedInformationValueWrapper implements RequestedInformationValueWrapper {

	private final RequestedInformation requestedInformationValue;

	public TxRequestedInformationValueWrapper(final RequestedInformation requestedInformationValue) {
		this.requestedInformationValue = requestedInformationValue;
	}

	@Override
	public boolean isCallConnectedElapsedTimeValueChosen() {
		return requestedInformationValue.getCallConnectedElapsedTimeValue() != null
				&& RequestedInformationType.callConnectedElapsedTime
						.equals(requestedInformationValue.getRequestedInformationType());
	}

	@Override
	public Integer getCallConnectedElapsedTimeValue() {
		if (requestedInformationValue.getCallConnectedElapsedTimeValue() != null
				&& RequestedInformationType.callConnectedElapsedTime
						.equals(requestedInformationValue.getRequestedInformationType())) {
			return requestedInformationValue.getCallConnectedElapsedTimeValue();
		}
		return null;
	}

	public RequestedInformation getTxRequestedInformationValue() {
		return requestedInformationValue;
	}

	@Override
	public String toString() {
		return "TxRequestedInformationValueWrapper [requestedInformationValue=" + requestedInformationValue + "]";
	}

}
