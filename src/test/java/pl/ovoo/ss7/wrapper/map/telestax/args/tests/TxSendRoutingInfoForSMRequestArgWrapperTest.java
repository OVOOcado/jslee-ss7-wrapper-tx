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

package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoForSMRequestArgWrapper;

public class TxSendRoutingInfoForSMRequestArgWrapperTest extends WrapperBaseTest {

    TxSendRoutingInfoForSMRequestArgWrapper txSendRoutingInfoForSMRequestArgWrapper;

    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoForSMRequestArgWrapper = new TxSendRoutingInfoForSMRequestArgWrapper();
        ISDNAddressString isdnAddressString = mapParameterFactory.createISDNAddressString(
                AddressNature.national_significant_number, NumberingPlan.land_mobile, "0048687983567");
        TxISDNAddressStringWrapperImpl txISDNAddressStringWrapper = new TxISDNAddressStringWrapperImpl(
                isdnAddressString);
        txSendRoutingInfoForSMRequestArgWrapper.setMsisdn(txISDNAddressStringWrapper);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txSendRoutingInfoForSMRequestArgWrapper);
        TxSendRoutingInfoForSMRequestArgWrapper tx = (TxSendRoutingInfoForSMRequestArgWrapper) deserializeFromFile();

        assertTrue(
                txSendRoutingInfoForSMRequestArgWrapper.getMsisdn().getAddress().equals(tx.getMsisdn().getAddress()));
        assertTrue(txSendRoutingInfoForSMRequestArgWrapper.getMsisdn().getNature().getValue() == tx.getMsisdn()
                .getNature().getValue());
        assertTrue(txSendRoutingInfoForSMRequestArgWrapper.getMsisdn().getNumberingPlan().getValue() == tx.getMsisdn()
                .getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoForSMRequestArgWrapper.getTxMsisdn().getAddress()
                .equals(tx.getTxMsisdn().getAddress()));
    }

}
