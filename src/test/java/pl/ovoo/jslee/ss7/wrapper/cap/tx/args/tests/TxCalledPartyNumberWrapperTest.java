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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.isup.message.parameter.CalledPartyNumber;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCalledPartyNumberWrapperTest extends WrapperBaseTest {

    TxCalledPartyNumberWrapper txCalledPartyNumberWrapper;

    @Before
    public void setUp() throws Exception {

        CalledPartyNumber calledPartyNumber = isupFactory.createCalledPartyNumber();
        calledPartyNumber.setNatureOfAddresIndicator(CalledPartyNumberWrapper.Nature.INTERNATIONAL.getValue());
        calledPartyNumber.setInternalNetworkNumberIndicator(
                CalledPartyNumberWrapper.RoutingToInternalNetworkNumber.ALLOWED.getValue());
        calledPartyNumber.setNumberingPlanIndicator(CalledPartyNumberWrapper.NumberingPlan.ISDN.getValue());
        calledPartyNumber.setAddress("0048123456789");
        CalledPartyNumberCap calledPartyNumberCap = capFactory.createCalledPartyNumberCap(calledPartyNumber);
        txCalledPartyNumberWrapper = new TxCalledPartyNumberWrapper(calledPartyNumberCap);
    }

    @Test
    public void testSerialization() throws ClassNotFoundException, IOException, CAPException {

        serializeToFile(txCalledPartyNumberWrapper);
        TxCalledPartyNumberWrapper tx = (TxCalledPartyNumberWrapper) deserializeFromFile();

        assertTrue(txCalledPartyNumberWrapper.getTxCalledPartyNumber().getCalledPartyNumber().getAddress()
                .equals(tx.getTxCalledPartyNumber().getCalledPartyNumber().getAddress()));
        assertTrue(txCalledPartyNumberWrapper.getTxCalledPartyNumber().getCalledPartyNumber()
                .getInternalNetworkNumberIndicator() == tx.getTxCalledPartyNumber().getCalledPartyNumber()
                        .getInternalNetworkNumberIndicator());
    }

}
