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
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.isup.message.parameter.CalledPartyNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.OriginalCalledNumber;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectingNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxOriginalCalledNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxRedirectingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxConnectArgWrapperTest extends WrapperBaseTest {

    TxConnectArgWrapper txConnectArgWrapper;

    @Before
    public void setUp() throws CAPException {

        txConnectArgWrapper = new TxConnectArgWrapper();
        CalledPartyNumber calledPartyNumber = isupFactory.createCalledPartyNumber();
        calledPartyNumber.setNatureOfAddresIndicator(CalledPartyNumberWrapper.Nature.INTERNATIONAL.getValue());
        calledPartyNumber.setInternalNetworkNumberIndicator(
                CalledPartyNumberWrapper.RoutingToInternalNetworkNumber.ALLOWED.getValue());
        calledPartyNumber.setNumberingPlanIndicator(CalledPartyNumberWrapper.NumberingPlan.ISDN.getValue());
        calledPartyNumber.setAddress("0048123456789");
        CalledPartyNumberCap calledPartyNumberCap = capFactory.createCalledPartyNumberCap(calledPartyNumber);

        CalledPartyNumberWrapper[] calledPartyNumberCapImpls = new CalledPartyNumberWrapper[1];
        calledPartyNumberCapImpls[0] = new TxCalledPartyNumberWrapper(calledPartyNumberCap);
        txConnectArgWrapper.setDestinationRoutingAddress(calledPartyNumberCapImpls);

        OriginalCalledNumber originalCalledNumber = isupFactory.createOriginalCalledNumber();
        originalCalledNumber.setNatureOfAddresIndicator(OriginalCalledNumberWrapper.Nature.INTERNATIONAL.getValue());
        originalCalledNumber.setAddress("0048143456763");
        originalCalledNumber.setAddressRepresentationRestrictedIndicator(123456789);
        originalCalledNumber.setNumberingPlanIndicator(987654321);
        OriginalCalledNumberCap originalCalledNumberCap = capFactory
                .createOriginalCalledNumberCap(originalCalledNumber);
        OriginalCalledNumberWrapper originalCalledPartyID = new TxOriginalCalledNumberWrapper(originalCalledNumberCap);
        txConnectArgWrapper.setOriginalCalledPartyID(originalCalledPartyID);

        RedirectingNumber redirectingNumber = isupFactory.createRedirectingNumber();
        redirectingNumber.setAddress("0048567865234");
        redirectingNumber.setNumberingPlanIndicator(678654123);
        RedirectingPartyIDCap redirectingPartyIDCap = capFactory.createRedirectingPartyIDCap(redirectingNumber);
        RedirectingPartyNumberWrapper redirectingPartyNumberWrapper = new TxRedirectingPartyNumberWrapper(
                redirectingPartyIDCap);
        txConnectArgWrapper.setRedirectingPartyID(redirectingPartyNumberWrapper);

    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {
        serializeToFile(txConnectArgWrapper);
        TxConnectArgWrapper tx = (TxConnectArgWrapper) deserializeFromFile();

        assertTrue(txConnectArgWrapper.getTxDestinationRoutingAddress().get(0).getCalledPartyNumber().getAddress()
                .equals(tx.getTxDestinationRoutingAddress().get(0).getCalledPartyNumber().getAddress()));
        assertTrue(txConnectArgWrapper.getTxOriginalCalledPartyID().getOriginalCalledNumber().getAddress()
                .equals(tx.getTxOriginalCalledPartyID().getOriginalCalledNumber().getAddress()));
        assertTrue(txConnectArgWrapper.getTxRedirectingPartyIDCap().getRedirectingNumber()
                .getNumberingPlanIndicator() == tx.getTxRedirectingPartyIDCap().getRedirectingNumber()
                .getNumberingPlanIndicator());

    }

}
