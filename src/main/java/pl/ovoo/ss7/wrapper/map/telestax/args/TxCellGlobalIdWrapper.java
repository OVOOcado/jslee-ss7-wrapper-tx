/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

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
