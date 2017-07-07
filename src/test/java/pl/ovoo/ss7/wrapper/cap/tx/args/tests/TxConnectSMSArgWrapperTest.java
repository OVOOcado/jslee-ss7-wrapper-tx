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

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxConnectSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;

public class TxConnectSMSArgWrapperTest extends WrapperBaseTest {

    TxConnectSMSArgWrapper txConnectSMSArgWrapper;

    @Before
    public void setUp() throws Exception {

        CalledPartyBCDNumber calledPartyBCDNumber = capFactory
                .createCalledPartyBCDNumber(AddressNature.international_number, NumberingPlan.ISDN, "0048237236123");
        ISDNAddressString isdnAddressString = mapParameterFactory
                .createISDNAddressString(AddressNature.international_number, NumberingPlan.data, "s");

        txConnectSMSArgWrapper = new TxConnectSMSArgWrapper(calledPartyBCDNumber, isdnAddressString);

        CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(
                calledPartyBCDNumber);
        ISDNAddressStringWrapper isdnaAddressStringWrapper = new TxISDNAddressStringWrapperImpl(isdnAddressString);
        txConnectSMSArgWrapper.setDestinationSubscriberNumber(calledPartyBCDNumberWrapper);
        txConnectSMSArgWrapper.setSMSCAddress(isdnaAddressStringWrapper);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {
        serializeToFile(txConnectSMSArgWrapper);
        TxConnectSMSArgWrapper tx = (TxConnectSMSArgWrapper) deserializeFromFile();

        assertTrue(txConnectSMSArgWrapper.getTxDestinationSubscriberNumber().getAddressNature().getIndicator() == tx
                .getTxDestinationSubscriberNumber().getAddressNature().getIndicator());
        assertTrue(txConnectSMSArgWrapper.getTxSmscAddress().getAddressNature() == tx.getTxSmscAddress()
                .getAddressNature());
        assertTrue(txConnectSMSArgWrapper.getTxSmscAddress().getNumberingPlan() == tx.getTxSmscAddress()
                .getNumberingPlan());

    }

}
