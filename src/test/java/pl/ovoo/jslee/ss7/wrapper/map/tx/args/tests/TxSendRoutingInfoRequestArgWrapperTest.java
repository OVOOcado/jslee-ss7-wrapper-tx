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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoRequestArgWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;

public class TxSendRoutingInfoRequestArgWrapperTest extends WrapperBaseTest {

    TxSendRoutingInfoRequestArgWrapper txSendRoutingInfoRequestArgWrapper;

    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoRequestArgWrapper = new TxSendRoutingInfoRequestArgWrapper();
        ISDNAddressString isdnAddressString = mapParameterFactory
                .createISDNAddressString(AddressNature.network_specific_number, NumberingPlan.ISDN, "0048678987345");
        TxISDNAddressStringWrapperImpl txISDNAddressStringWrapperImpl = new TxISDNAddressStringWrapperImpl(
                isdnAddressString);
        txSendRoutingInfoRequestArgWrapper.setMsisdn(txISDNAddressStringWrapperImpl);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txSendRoutingInfoRequestArgWrapper);
        TxSendRoutingInfoRequestArgWrapper tx = (TxSendRoutingInfoRequestArgWrapper) deserializeFromFile();

        assertTrue(txSendRoutingInfoRequestArgWrapper.getMsisdn().getAddress().equals(tx.getMsisdn().getAddress()));
        assertTrue(txSendRoutingInfoRequestArgWrapper.getMsisdn().getNature().getValue() == tx.getMsisdn().getNature()
                .getValue());
        assertTrue(txSendRoutingInfoRequestArgWrapper.getMsisdn().getNumberingPlan().getValue() == tx.getMsisdn()
                .getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoRequestArgWrapper.getTxMsisdn().getAddressNature().getIndicator() == tx
                .getTxMsisdn().getAddressNature().getIndicator());
        assertTrue(txSendRoutingInfoRequestArgWrapper.getTxMsisdn().getAddress().equals(tx.getTxMsisdn().getAddress()));

    }

}
