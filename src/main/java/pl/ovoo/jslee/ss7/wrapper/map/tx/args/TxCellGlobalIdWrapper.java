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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdFixedLength;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.map.args.CellGlobalIdWrapper;

/**
 * TxCellGlobalIdWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCellGlobalIdWrapper implements CellGlobalIdWrapper {

    private final CellGlobalIdOrServiceAreaIdFixedLength cellGlobalIdOrServiceAreaIdFixedLength;

    public TxCellGlobalIdWrapper(final CellGlobalIdOrServiceAreaIdFixedLength cellGlobalIdOrServiceAreaIdFixedLength) {
        this.cellGlobalIdOrServiceAreaIdFixedLength = cellGlobalIdOrServiceAreaIdFixedLength;
    }

    @Override
    public boolean hasMobileCountryCode() {
        return true;
    }

    @Override
    public String getMobileCountryCode() throws Ss7WrapperException {
        try {
            return Integer.toString(cellGlobalIdOrServiceAreaIdFixedLength.getMCC());
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasMobileNetworkCode() {
        return true;
    }

    @Override
    public String getMobileNetworkCode() throws Ss7WrapperException {
        try {
            return Integer.toString(cellGlobalIdOrServiceAreaIdFixedLength.getMNC());
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasCellId() {
        return true;
    }

    @Override
    public int getCellId() throws Ss7WrapperException {
        try {
            return cellGlobalIdOrServiceAreaIdFixedLength.getCellIdOrServiceAreaCode();
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasLocationAreaCode() {
        return true;
    }

    @Override
    public int getLocationAreaCode() throws Ss7WrapperException {
        try {
            return cellGlobalIdOrServiceAreaIdFixedLength.getLac();
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public String toString() {
        return "TxCellGlobalIdWrapper [cellGlobalIdOrServiceAreaIdFixedLength=" + cellGlobalIdOrServiceAreaIdFixedLength
                + "]";
    }

}
