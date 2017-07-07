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
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoForSMResponseWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;

public class TxSendRoutingInfoForSMResponseWrapperTest extends WrapperBaseTest {
    TxSendRoutingInfoForSMResponseWrapper txSendRoutingInfoForSMResponseWrapper;

    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoForSMResponseWrapper = new TxSendRoutingInfoForSMResponseWrapper();
        IMSI imsi = mapParameterFactory.createIMSI("260345678456789");
        TxIMSIAddressWrapper txIMSIAddressWrapper = new TxIMSIAddressWrapper(imsi);
        txSendRoutingInfoForSMResponseWrapper.setImsi(txIMSIAddressWrapper);
        ISDNAddressString isdnAddressString = mapParameterFactory.createISDNAddressString(
                AddressNature.network_specific_number, NumberingPlan.land_mobile, "0048678675987");
        TxISDNAddressStringWrapperImpl txISDNAddressStringWrapperImpl = new TxISDNAddressStringWrapperImpl(
                isdnAddressString);
        txSendRoutingInfoForSMResponseWrapper.setMscAddress(txISDNAddressStringWrapperImpl);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txSendRoutingInfoForSMResponseWrapper);
        TxSendRoutingInfoForSMResponseWrapper tx = (TxSendRoutingInfoForSMResponseWrapper) deserializeFromFile();

        assertTrue(txSendRoutingInfoForSMResponseWrapper.getIMSI().getAddress().equals(tx.getIMSI().getAddress()));
        assertTrue(txSendRoutingInfoForSMResponseWrapper.getMscAddress().getNumberingPlan().getValue() == tx
                .getMscAddress().getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoForSMResponseWrapper.getTxImsi().getData().equals(tx.getTxImsi().getData()));
        assertTrue(txSendRoutingInfoForSMResponseWrapper.getTxMscAddress().getAddressNature().getIndicator() == tx
                .getTxMscAddress().getAddressNature().getIndicator());
    }

}
