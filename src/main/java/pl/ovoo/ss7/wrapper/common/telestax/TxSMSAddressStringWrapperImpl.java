/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.common.telestax;

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSAddressString;
import pl.ovoo.ss7.wrapper.common.args.SMSAddressStringWrapper;

public class TxSMSAddressStringWrapperImpl implements SMSAddressStringWrapper{

	private final SMSAddressString address;

	public TxSMSAddressStringWrapperImpl(final SMSAddressString address) {
		super();
		this.address = address;
	}

	@Override
	public String getAddress() {
		return address.getAddress();
	}

	@Override
	public Nature getNature() {
		if (address.getAddressNature() != null) {
			return Nature.valueOf(address.getAddressNature().getIndicator());
		}
		return null;
	}

	@Override
	public NumberingPlan getNumberingPlan() {
		if (address.getNumberingPlan() != null) {
			return NumberingPlan.valueOf(address.getNumberingPlan().getIndicator());
		}
		return null;
	}

	@Override
	public boolean hasAddress(){
		return address.getAddress() != null;
	}

	@Override
	public boolean hasNature(){
		return address.getAddressNature() != null;
	}

	@Override
	public boolean hasNumberingPlan(){
		return address.getNumberingPlan() != null;
	}

	public SMSAddressString getTxAddress() {
		return address;
	}
}
