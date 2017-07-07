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

package pl.ovoo.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CallingPartyNumberCap;
import org.mobicents.protocols.ss7.isup.message.parameter.CallingPartyNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCallingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCallingPartyNumberWrapperTest extends WrapperBaseTest {

	TxCallingPartyNumberWrapper txCallingPartyNumberWrapper;

	@Before
	public void setUp() throws Exception {

		CallingPartyNumber callingPartyNumber = isupFactory.createCallingPartyNumber();
		callingPartyNumber.setNatureOfAddresIndicator(CallingPartyNumberWrapper.Nature.INTERNATIONAL.getValue());
		callingPartyNumber.setAddress("0048123456789");
		CallingPartyNumberCap callingPartyNumberCap = capFactory.createCallingPartyNumberCap(callingPartyNumber);
		txCallingPartyNumberWrapper = new TxCallingPartyNumberWrapper(callingPartyNumberCap);
	}

	@Test
	public void testSerialization() throws ClassNotFoundException, IOException, Ss7WrapperException, CAPException {
		serializeToFile(txCallingPartyNumberWrapper);
		TxCallingPartyNumberWrapper tx = (TxCallingPartyNumberWrapper) deserializeFromFile();

		assertTrue(txCallingPartyNumberWrapper.getNature().getValue() == tx.getNature().getValue());
		assertTrue(txCallingPartyNumberWrapper.getTxCallingPartyNumber().getCallingPartyNumber().getAddress()
				.equals(tx.getTxCallingPartyNumber().getCallingPartyNumber().getAddress()));
	}

}
