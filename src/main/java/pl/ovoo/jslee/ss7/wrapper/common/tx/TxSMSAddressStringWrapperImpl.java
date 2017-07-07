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

package pl.ovoo.jslee.ss7.wrapper.common.tx;

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
